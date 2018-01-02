// đối tượng gửi về RESTAIP
function CourseWrapper() {
  var courses = [];
}

// xử lý điều kiện và tạo đối tượng trước ghi gửi về RESTAPI
function prefixProcess(courseList) {
  // convert array to object
  var listCourseObject = [];
  var course_wrapper = new CourseWrapper();
  // check for null
  if (courseList) {
    var courses = [];
    courseList.forEach(one_course_id => {
      var one_course_object = {};
      one_course_object.id = one_course_id;
      courses.push(one_course_object);
    });
    course_wrapper.courses = courses;
  }
  return course_wrapper;
}

function searchAjax(courseList) {

  // prefixProcess get list_course: input-> ajax
  var list_course_object = prefixProcess(courseList);
  // gọi ajax gửi đên API để lấy thông tin các course
  $.ajaxSetup({
    type: "POST",
    contentType: "application/json",
    url: "/PortfolioManagement-test/showListCouses",
    beforeSend: function () {
      console.log("here");
      $(".loading ").show();
    },
    complete: function () {
      $(".loading ").hide();
    }
  });
  $.ajax({

    data: JSON.stringify(list_course_object),
    dataType: 'json',
    timeout: 100000,
    success: function (data) {
      loadCourseList(data);
    },
    error: function (e) {
      console.log("ERROR: ", e);
    },
    done: function (e) {
      console.log("DONE");
    }
  });
}
// courseList dùng chung
var courseList;
function loadCourseList(data) {
  var element = document.getElementById("CourseForm");
  element.innerHTML = "";
  courseList = data.courses;
  // console.log(JSON.stringify(courseList));
  courseList.forEach(one_course => {
    //tạo 1 row
    var div_one_course = document.createElement('div');
    div_one_course.id = "one_course";
    div_one_course.className = "row";

    // tiêu đề course
    var h1_course_name = document.createElement('h1');
    h1_course_name.className = "one_course_name";
    h1_course_name.innerHTML = one_course.course_name;
    div_one_course.appendChild(h1_course_name);

    var div_form_group = document.createElement('div');
    div_form_group.className = "form-group";
    div_one_course.appendChild(div_form_group);

    // create label course name
    var label_lv = document.createElement('label');
    label_lv.className = "control-label  col-sm-3 col-sm-offset-1 label_69";
    label_lv.innerHTML = "単元タグ設定パターン";
    div_form_group.appendChild(label_lv);
    var div_right_select_lv = document.createElement('div');
    div_right_select_lv.className = "col-sm-4";
    div_form_group.appendChild(div_right_select_lv);

    //create select Level
    var div_right_select_custom = document.createElement('div');
    div_right_select_custom.className = "level_list";
    div_right_select_lv.appendChild(div_right_select_custom);

    var select_custom = document.createElement('select');
    select_custom.className = "custom_select_level";
    div_right_select_custom.appendChild(select_custom);

    var level_list = one_course.level_list;
    var option_lv_size = level_list.length;

    select_custom.setAttribute("onchange", 'list_lv_change(this,' + one_course.id + ');');
    select_custom.setAttribute("from_course_id", one_course.id);

    //create option inside select level
    level_list.forEach(one_level => {
      var option = document.createElement("option");
      option.value = one_level.level;
      option.text = one_level.level;
      select_custom.appendChild(option);
    });

    var div_form_group_attribute = document.createElement('div');
    div_form_group_attribute.className = "form-group";
    div_one_course.appendChild(div_form_group_attribute);

    var label_lv_attribute = document.createElement('label');
    label_lv_attribute.className = "control-label col-sm-2 col-sm-offset-2 label_69";
    label_lv_attribute.innerHTML = "単元タグ";

    div_form_group_attribute.appendChild(label_lv_attribute);

    var div_form_group_attribute_right = document.createElement('div');
    div_form_group_attribute_right.className = "col-sm-8";
    div_form_group_attribute.appendChild(div_form_group_attribute_right);
    var ul_form_group_attribute_right = document.createElement('ul');
    ul_form_group_attribute_right.className = "patern_list ";
    ul_form_group_attribute_right.id = "question_attribute_list_from_course_" + one_course.id;
    div_form_group_attribute_right.appendChild(ul_form_group_attribute_right);

    var current_lv_option = level_list[0].level_id;
    var question_attribute_list = level_list[0].question_attribute_list;
    //create question attribute of one_level_selected
    question_attribute_list.forEach(each_question_attibute_list => {
      var one_question = document.createElement('li');
      one_question.value = each_question_attibute_list.question_attribute_name;
      one_question.innerHTML = each_question_attibute_list.question_attribute_name;
      ul_form_group_attribute_right.appendChild(one_question);
    });
    element.appendChild(div_one_course);
  });
}


function course_change() {

  var courseListSelected = $('#course_selected').val();
  // check for null
  if (courseListSelected) {
    var data = {};
    // prefixProcess get list_course: input-> ajax
    var list_course_object = prefixProcess(courseListSelected);
    var element = document.getElementById("CourseForm");
    element.innerHTML = "";
    if (courseListSelected.length > 8) {
      alert("");
    }
    else {
      searchAjax(courseListSelected);
    }
  }
}
$(document).ready(function () {
  $('#course_selected').change(function () {
    // sự kiện thay đổi multipe select course xảy ra
    course_change();
  });
});


function list_lv_change(this_selected_lv, course_id) {

  var lv_selected = this_selected_lv.options[this_selected_lv.selectedIndex].value;
  courseList.forEach(one_course => {
    if (one_course.id == course_id) {
      var list_question = document.getElementById('question_attribute_list_from_course_' + course_id);
      list_question.innerHTML = "";
      var level_list = one_course.level_list;
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