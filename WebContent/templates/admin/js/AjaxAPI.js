// json mẫu nhận được khi ajax gửi request yêu cầu dữ liệu courses từ server xem ở trang dưới 
// http://jsoneditoronline.org/?id=8bc76a7b412279a8d1ad2e7c35ee85d2

// đối tượng gửi về RESTAIP
function ServicePortfolioCourseWrapper() {
  var spcourses = [];
}

$(document).ready(function () {
	  $('#SP_Course_Selected').change(function () {
	    // sự kiện thay đổi multipe select ServicePortfolioCourse xảy ra
	    spcs_change();
	  });
	});

// xử lý điều kiện và tạo đối tượng trước ghi gửi về RESTAPI
function prefixProcess(spcList) {
  // convert array to object
  var listCourseObject = [];
  var spcWrap = new ServicePortfolioCourseWrapper();
  // check for null
  if (spcList) {
    var spcs = [];
    spcList.forEach(one_course_id => {
      var one_sp_course_object = {};
      one_sp_course_object.id = one_course_id;
      spcs.push(one_sp_course_object);
    });
    spcWrap.spcourses = spcs;
  }
  return spcWrap;
}

function searchAjax(spcList) {

  // prefixProcess get list_course: input-> ajax
  var spc_object = prefixProcess(spcList);
  // gọi ajax gửi đên API để lấy thông tin các course
  $.ajaxSetup({
    type: "POST",
    contentType: "application/json",
    url: "/PortfolioManagement/showListCouses",
    beforeSend: function () {
      $(".loading ").show();
    },
    complete: function () {
      $(".loading ").hide();
    }
  });
  $.ajax({
    data: JSON.stringify(spc_object),
    dataType: 'json',
    timeout: 100000,
    success: function (data) {
      loadInfoFromSPC(data);
    },
    error: function (e) {
      console.log("ERROR: ", e);
    },
    done: function (e) {
      console.log("DONE");
    }
  });
}
// spcList dùng chung
var spcList;
function loadInfoFromSPC(data) {
  var element = document.getElementById("SPCourseForm");
  element.innerHTML = "";
  spcList = data.spcourses;
  // console.log(JSON.stringify(spcList));
  var index=0;
  spcList.forEach(one_sp_course => {
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
    input.type="hidden";
    input.name= "pccs["+ index +"].id	";
    input.value=  one_sp_course.id;
    
    
    var select_custom = document.createElement('select');
    select_custom.className = "custom_select_level";
    select_custom.name="pccs["+ index +"].level";
    index++;
    div_right_select_custom.appendChild(select_custom);
    div_right_select_custom.appendChild(input);
  
    var option_lv_size = level_list.length;

    select_custom.setAttribute("onchange", 'list_lv_change(this,' + one_sp_course.id + ');');
    select_custom.setAttribute("from_course_id", one_sp_course.id);
    
    // create option inside select level
    level_list.forEach(one_level => {
      var option = document.createElement("option");
      option.value = one_level.level;
      option.text = one_level.level;
      select_custom.appendChild(option);
    });

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
    ul_form_group_attribute_right.id = "question_attribute_list_from_course_" + one_sp_course.id;
    div_form_group_attribute_right.appendChild(ul_form_group_attribute_right);

    var current_lv_option = level_list[0].level_id;
    var question_attribute_list = level_list[0].question_attribute_list;
    // create question attribute of one_level_selected
    question_attribute_list.forEach(each_question_attibute_list => {
      var one_question = document.createElement('li');
      one_question.value = each_question_attibute_list.question_attribute_name;
      one_question.innerHTML = each_question_attibute_list.question_attribute_name;
      ul_form_group_attribute_right.appendChild(one_question);
    });
    element.appendChild(div_one_sp_course);
  });
}

//ServicePortfolioCourse event change listener
function spcs_change() {

  var spclistSelected = $('#SP_Course_Selected').val();
  // check for null
  if (spclistSelected) {
    var data = {};
    // prefixProcess get list_course: input-> ajax
    var spc_object = prefixProcess(spclistSelected);
    var element = document.getElementById("SPCourseForm");
    element.innerHTML = "";
    if (spclistSelected.length > 8) {
      alert("");
    }
    else {
      searchAjax(spclistSelected);
    }
  }
}


function list_lv_change(this_selected_lv, course_id) {

  var lv_selected = this_selected_lv.options[this_selected_lv.selectedIndex].value;
  spcList.forEach(one_sp_course => {
    if (one_sp_course.id == course_id) {
      var list_question = document.getElementById('question_attribute_list_from_course_' + course_id);
      list_question.innerHTML = "";
      var level_list = one_sp_course.level_list;
      level_list.forEach(one_level => {
        if (one_level.level == lv_selected) {
          var question_attribute_list = one_level.question_attribute_list;
          question_attribute_list.forEach(each_question_attibute_list => {
            var one_question = document.createElement('li');
            one_question.value = each_question_attibute_list.question_attribute_name;
            one_question.innerHTML = each_question_attibute_list.question_attribute_name;
            list_question.appendChild(one_question);
          });
        }
      });
    }
  }
  );
};