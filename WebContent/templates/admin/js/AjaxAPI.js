// json mẫu nhận được khi ajax gửi request yêu cầu dữ liệu courses từ server xem ở trang dưới 
// http://jsoneditoronline.org/?id=8bc76a7b412279a8d1ad2e7c35ee85d2

// biến lưu trữ những spc mà người dùng đã chọn
// spcList dùng chung
var spcListDataSave = [];
var saveSPCSelected = [];
function SpcSelected() {
  var spcId;
  var level;
}
// đối tượng gửi về RESTAIP
function ServicePortfolioCourseWrapper() {
  var spcourses = [];
}
// lưu trả database SPC lưu trử ở client

$(document).ready(function () {

  // nếu người dùng đã chọn 1 spc rồi
  if ($('#SP_Course_Selected').val()) {
	  var element = document.getElementById("SPCourseForm");
    // trường hợp người dùng bấm back
    if (element.innerHTML == "") {
      searchAjax($('#SP_Course_Selected').val(), 1);
    } else {
      searchAjax($('#SP_Course_Selected').val(), 0);
      var numberOfSPcourse = $("#SPCourseForm").children('div').length;
      var i;
      saveSPCSelected = [];
      for (i = 0; i < numberOfSPcourse; i++) {
        var one_div_sp_course = $("#SPCourseForm").children('div').eq(i).children('div').eq(0).children('div').eq(0).children('div').eq(0).children('select').eq(0);
        var spcSelected = new SpcSelected();
        spcSelected.level = $("#SPCourseForm").children('div').eq(i).find("select").val();
        spcSelected.spcId = $("#SPCourseForm").children('div').eq(i).find("input").val();
        saveSPCSelected.push(spcSelected);
      }
    }
  }

  // send API
  $('#SP_Course_Selected').change(function () {
    // sự kiện thay đổi multipe select ServicePortfolioCourse xảy ra
    spcs_change();
  });
  // validate Client
  $("#spc_insert_form").submit(function () {
    // event.preventDefault();
    // validateInsertSPCF();

  });
});

// xử lý điều kiện và tạo đối tượng trước ghi gửi về RESTAPI
// hàm này nhận input là 1 list spc được chọn từ người dùng
// loại bỏ những id đã được lưu trữ ở saveSPCselected từ trước
// để tạo đối tượng cần thêm dữ liệu lên server yêu cầu dữ liệu
// đồng thời loại bỏ những id không còn được người dùng chọn nữa trong
// saveSPCselected
function prefixProcess(spcList) {
  // convert array to object
  var listCourseObject = [];
  var spcWrap = new ServicePortfolioCourseWrapper();
  // check for null
  var saveChoose = [];
  if (spcList) {
    var spcs = [];
    // xử lý loại bỏ những id của spc nào người dùng không chọn nữa
    // và thêm mới những id người dùng mới thêm vào tạo thành saveSPCSelected
    spcList.forEach(one_course_id => {
      var one_sp_course_object = {};
      one_sp_course_object.id = one_course_id;
      var ck = 1;

      for (var i = 0; i < saveSPCSelected.length; i++) {
        if (saveSPCSelected[i].spcId == one_sp_course_object.id) {
          // đã lưu dữ liệu trước đây rồi
          ck = 0;
          saveChoose.push(saveSPCSelected[i]);
          break;
        }
      }
      if (ck) {
        var spcSelected = new SpcSelected();
        spcSelected.level = 1;
        spcSelected.spcId = one_sp_course_object.id;
        saveChoose.push(spcSelected);
      }
    });
    saveSPCSelected = [];
    saveSPCSelected = saveChoose;
    // tiến hành kiểm tra spcs kiểm tra những id nào đã được lấy dữ liệu rồi
    spcList.forEach(one_course_id => {
      var one_sp_course_object = {};
      one_sp_course_object.id = one_course_id;
      var ck = 1;
      spcListDataSave.forEach(one_sp_course => {
        if (one_course_id == one_sp_course.id) {
          ck = 0;
        }
      });
      // console.log(one_course_id);
      if (ck) spcs.push(one_sp_course_object);
    });
    spcWrap.spcourses = spcs;
  }
  console.log(spcWrap);
  return spcWrap;
}
function searchAjax(spcList, isLoad = 1) {

  // prefixProcess get list_course: input-> ajax

  var spc_object = prefixProcess(spcList);
  // loại những khóa học đã lưu dữ liệu


  // gọi ajax gửi đên API để lấy thông tin các course
  $.ajaxSetup({
    type: "POST",
    contentType: "application/json",
    url: "/PortfolioManagement/showListCouses",
    beforeSend: function () {
      $(".loading ").show();
      $("#SPCourseForm ").hide();
      $("#btnSubmit").attr("disabled", true);
    },
    complete: function () {
      $(".loading ").hide();
      $("#btnSubmit").removeAttr("disabled");
      $("#SPCourseForm ").show();
    }
  });
  $.ajax({
    data: JSON.stringify(spc_object),
    dataType: 'json',
    timeout: 100000,
    success: function (data) {
      saveData(data);
      if (isLoad) {
        loadInfoFromSPC(data);
      }

    },
    error: function (e) {
      console.log("ERROR: ", e);
    },
    done: function (e) {
      console.log("DONE");
    }
  });
}


function saveData(data) {
  data.spcourses.forEach(one_sp_course => {
    spcListDataSave.push(one_sp_course);
  })
};
function loadInfoFromSPC(data, level_seleted = 1) {
  var element = document.getElementById("SPCourseForm");
  element.innerHTML = "";

  // console.log(JSON.stringify(spcList));
  var index = -1;
  saveSPCSelected.forEach(saveSPC => {
    spcListDataSave.forEach(one_sp_course => {
      if(one_sp_course.id==saveSPC.spcId){
        index++;
        // đối tượng level_list chứa thông tin về các level của 1 course
        // đồng thời mỗi level sẽ có danh sách những attribute riêng
        var level_list = one_sp_course.level_list;
  
        // tạo 1 row
        var div_one_sp_course = document.createElement('div');
        div_one_sp_course.id = "one_sp_course";
        div_one_sp_course.className = "row";
  
        // tiêu đề course
        var h1_course_name = document.createElement('h1');
        h1_course_name.className = "one_course_name";
        h1_course_name.innerHTML = one_sp_course.course_name;
        div_one_sp_course.appendChild(h1_course_name);
  
        var div_form_group = document.createElement('div');
        div_form_group.className = "form-group";
        div_one_sp_course.appendChild(div_form_group);
  
        // create label course name
        var label_lv = document.createElement('label');
        label_lv.className = "control-label  col-sm-3 col-sm-offset-1 label_69";
        label_lv.innerHTML = "単元タグ設定パターン";
        div_form_group.appendChild(label_lv);
        var div_right_select_lv = document.createElement('div');
        div_right_select_lv.className = "col-sm-4";
        div_form_group.appendChild(div_right_select_lv);
  
        // create select Level
        var div_right_select_custom = document.createElement('div');
        div_right_select_custom.className = "level_list";
        div_right_select_lv.appendChild(div_right_select_custom);
  
        var input = document.createElement("input");
        input.type = "hidden";
        input.name = "pccs[" + index + "].service_portfolio_course_id";
        input.value = one_sp_course.id;
  
  
        var select_custom = document.createElement('select');
        select_custom.className = "custom_select_level";
        select_custom.name = "pccs[" + index + "].level";
  
        div_right_select_custom.appendChild(select_custom);
        div_right_select_custom.appendChild(input);
  
        var option_lv_size = level_list.length;
  
        select_custom.setAttribute("onchange", 'list_lv_change(this,' + one_sp_course.id + ');');
  
        // create option inside select level
        level_list.forEach(one_level => {
          var option = document.createElement("option");
          option.value = one_level.level;
          option.text = "パターン" + one_level.level;
          if (option.value == saveSPC.level) {
            option.selected = "true";
          }
          select_custom.appendChild(option);
        });
        // create error label
        var label_lv_error = document.createElement('label');
        label_lv_error.id = "label_level_error" + index;
        label_lv_error.className = "label_level_error control-label  col-sm-3 ";
        label_lv_error.innerHTML = "";
        div_form_group.appendChild(label_lv_error);
  
        var div_form_group_attribute = document.createElement('div');
        div_form_group_attribute.className = "form-group";
        div_one_sp_course.appendChild(div_form_group_attribute);
  
        var label_lv_attribute = document.createElement('label');
        label_lv_attribute.className = "control-label col-sm-2 col-sm-offset-2 label_69";
        label_lv_attribute.innerHTML = "単元タグ";
  
        div_form_group_attribute.appendChild(label_lv_attribute);
  
        var div_form_group_attribute_right = document.createElement('div');
        div_form_group_attribute_right.className = "col-sm-8";
        div_form_group_attribute.appendChild(div_form_group_attribute_right);
        var ul_form_group_attribute_right = document.createElement('ul');
        ul_form_group_attribute_right.className = "patern_list ";
        ul_form_group_attribute_right.id = "question_attribute_list_from_spcourse_" + one_sp_course.id;
        div_form_group_attribute_right.appendChild(ul_form_group_attribute_right);
  
        // hiển thị element lên view
        element.appendChild(div_one_sp_course);
  
        // load_list_level
        console.log(saveSPC.level);
        load_list_level(saveSPC.level, one_sp_course.id);
  
        // var level=;
        // var courseid=;
        // console.log(numberOfSPcourse);
      }
     
    });
  });

}

// ServicePortfolioCourse event change listener
function spcs_change() {
  var spclistSelected = $('#SP_Course_Selected').val();
  // check for null
  if (spclistSelected) {
    var element = document.getElementById("SPCourseForm");
    element.innerHTML = "";

    searchAjax(spclistSelected);
  } else {
    // không chọn gì cả
    var element = document.getElementById("SPCourseForm");
    element.innerHTML = "";
  }
}



function list_lv_change(this_selected_lv, spcourse_id) {
  var lv_selected = this_selected_lv.options[this_selected_lv.selectedIndex].value;
  for (var i = 0; i < saveSPCSelected.length; i++) {
    if (saveSPCSelected[i].spcId == spcourse_id) {
      saveSPCSelected[i].level = lv_selected;
    }
  }
  load_list_level(lv_selected, spcourse_id);
};
function load_list_level(level_seleted, spcourse_id) {
  spcListDataSave.forEach(one_sp_course => {
    if (one_sp_course.id == spcourse_id) {
      var list_question = document.getElementById('question_attribute_list_from_spcourse_' + spcourse_id);
      list_question.innerHTML = "";
      var level_list = one_sp_course.level_list;
      level_list.forEach(one_level => {
        if (one_level.level == level_seleted) {
          var question_attribute_list = one_level.question_attribute_list;
          question_attribute_list.forEach(each_question_attibute_list => {
            var one_question = document.createElement('li');
            one_question.innerHTML = each_question_attibute_list.question_attribute_name;
            list_question.appendChild(one_question);
          });
        }
      });
    }
  }
  );
}


// validate form in client
function validateInsertSPCF() {
  // validateSPCName();
  // validateNumberSPCName();
  // validateLevel();
}
function validateSPCName() {
  let spcf_name = $("#spcf_name").val();
  var spc_name_error = $("#spc_name_error").t;
  $("#spc_name_error").text("");
  if (spcf_name === "") {
    $("#spc_name_error").text("必須入力とする");
  }
  else if (spcf_name.length > 32) {
    $("#spc_name_error").text("最大32文字まで入力可能とする");
  }
  else {
    return 1;
  }

  return 0;
}
function validateNumberSPCName() {
  var spclistSelected = $('#SP_Course_Selected').val();
  $("#spc_list_error").text("");
  if (!spclistSelected) {
    $("#spc_list_error").text("対象科目を選択してください");
  } else if (spclistSelected.length > 8) {
    $("#spc_list_error").text("選択できる対象科目は８個までです。");
  } else {
    return 1;
  }
  return 0;
}
// function validateLevel() {
// var levelSelecteds = document.getElementsByClassName("custom_select_level");
// var label_errors = document.getElementsByClassName("label_level_error");
// if (levelSelecteds) {
// for (var k = 0; i < levelSelecteds.length; k++) {
// var level = parseInt(levelSelecteds[k].value);
// if (level > 3 || level < 0) {
// label_errors[k].innerHTML("パターンは1から3までの半角数字のみ入力可能です");
// } else {
// if(label_errors.text!=""){
// label_errors[k].innerHTML("");
// }
// return 1;
// }
// }
// }
// return 0;
// }
