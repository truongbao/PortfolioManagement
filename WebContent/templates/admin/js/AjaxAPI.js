var fakeJsonRespone =
  [
    {
      "course_id": "1",
      "course_name": "course_01",
      "level_list": [
        {
          "level_id": "level_1",
          "question_attribute_list": [
            {
              "each_question_attibute_list": "l1_att_1"
            },
            {
              "each_question_attibute_list": "l1_att_2"
            },
            {
              "each_question_attibute_list": "l1_att_3"
            }
          ]
        },
        {
          "level_id": "level_2",
          "question_attribute_list": [
            {
              "each_question_attibute_list": "l2_att_1"
            },
            {
              "each_question_attibute_list": "l2_att_2"
            },
            {
              "each_question_attibute_list": "l2_att_3"
            }
          ]
        },
        {
          "level_id": "level_3",
          "question_attribute_list": [
            {
              "each_question_attibute_list": "l3_att_1"
            },
            {
              "each_question_attibute_list": "l3_att_2"
            },
            {
              "each_question_attibute_list": "l3_att_3"
            }
          ]
        }
      ]
    },
    {
      "course_id": "2",
      "course_name": "course_02",
      "level_list": [
        {
          "level_id": "level_1",
          "question_attribute_list": [
            {
              "each_question_attibute_list": "l1_att_1"
            },
            {
              "each_question_attibute_list": "l1_att_2"
            },
            {
              "each_question_attibute_list": "l1_att_3"
            }
          ]
        },
        {
          "level_id": "level_2",
          "question_attribute_list": [
            {
              "each_question_attibute_list": "l2_att_1"
            },
            {
              "each_question_attibute_list": "l2_att_2"
            },
            {
              "each_question_attibute_list": "l2_att_3"
            }
          ]
        },
        {
          "level_id": "level_3",
          "question_attribute_list": [
            {
              "each_question_attibute_list": "l3_att_1"
            },
            {
              "each_question_attibute_list": "l3_att_2"
            },
            {
              "each_question_attibute_list": "l3_att_3"
            }
          ]
        }
      ]
    },
    {
      "course_id": "3",
      "course_name": "course_03",
      "level_list": [
        {
          "level_id": "level_1",
          "question_attribute_list": [
            {
              "each_question_attibute_list": "l1_att_1"
            },
            {
              "each_question_attibute_list": "l1_att_2"
            },
            {
              "each_question_attibute_list": "l1_att_3"
            }
          ]
        },
        {
          "level_id": "level_2",
          "question_attribute_list": [
            {
              "each_question_attibute_list": "l2_att_1"
            },
            {
              "each_question_attibute_list": "l2_att_2"
            },
            {
              "each_question_attibute_list": "l2_att_3"
            }
          ]
        },
        {
          "level_id": "level_3",
          "question_attribute_list": [
            {
              "each_question_attibute_list": "l3_att_1"
            },
            {
              "each_question_attibute_list": "l3_att_2"
            },
            {
              "each_question_attibute_list": "l3_att_3"
            }
          ]
        }
      ]
    }
  ];

$(document).ready(function () {
  $('#course_selected').change(function () {

    course_change();
  });
});

function course_change() {
  var courseList = $('#course_selected').val();
  var genarateCourse = "";
  var i = 0;
  var number_length = courseList.length - 0;  
  if(number_length>8){
    alert("");
  }
  else {

  }
  //gửi lấy về json
  var element = document.getElementById("CourseForm");
  element.innerHTML = "";
  for (i = 0; i < number_length; ++i) {
    //create div with one_course div
    var div_one_course = document.createElement('div');
    div_one_course.id = "one_course";
    div_one_course.className = "row";

    var h1_course_name = document.createElement('h1');
    h1_course_name.className = "one_course_name";
    h1_course_name.innerHTML = fakeJsonRespone[i].course_name;
    div_one_course.appendChild(h1_course_name);

    var div_form_group = document.createElement('div');
    div_form_group.className = "form-group";
    div_one_course.appendChild(div_form_group);

    // //create label course name
    var label_lv = document.createElement('label');
    label_lv.className = "control-label  col-sm-3 col-sm-offset-1 label_69";
    label_lv.innerHTML = "単元タグ設定パターン";
    div_form_group.appendChild(label_lv);

    var div_right_select_lv = document.createElement('div');
    div_right_select_lv.className = "col-sm-4";

    div_form_group.appendChild(div_right_select_lv);

    var div_right_select_custom = document.createElement('div');
    div_right_select_custom.className = "level_list";
    div_right_select_lv.appendChild(div_right_select_custom);


    var select_custom = document.createElement('select');
    select_custom.className = "custom_select_level";
    div_right_select_custom.appendChild(select_custom);

    var level_list = fakeJsonRespone[i].level_list;
    var option_lv_size = level_list.length;
    var string_test = JSON.stringify(level_list);
    //     var slecthtml = '<select id="lv_id_' + courseList[i] + '" name="lv_id_' + courseList[i] + '" onchange=list_lv_change("' + courseList[i] + '",this,' + string_test + ')>';
    select_custom.setAttribute("onchange", 'list_lv_change(this,' + fakeJsonRespone[i].course_id + ');');
    select_custom.setAttribute("from_course_id", fakeJsonRespone[i].course_id);

    for (var j = 0; j < option_lv_size; j++) {
      var option = document.createElement("option");
      option.value = level_list[j].level_id;
      option.text = level_list[j].level_id;
      select_custom.appendChild(option);
    }
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
    ul_form_group_attribute_right.id = "question_attribute_list_from_course_" + fakeJsonRespone[i].course_id;
    div_form_group_attribute_right.appendChild(ul_form_group_attribute_right);

    var current_lv_option = level_list[0].level_id;
    var current_question_attribute_list = level_list[0].question_attribute_list;
    var question_list_size = current_question_attribute_list.length;

    for (var j = 0; j < question_list_size; j++) {
      var one_question = document.createElement('li');
      one_question.value = current_question_attribute_list[j].each_question_attibute_list;
      one_question.innerHTML = current_question_attribute_list[j].each_question_attibute_list;
      ul_form_group_attribute_right.appendChild(one_question);
    }
    element.appendChild(div_one_course);
  }
}
function list_lv_change(this_selected_lv, course_id) {

  var lv_selected = this_selected_lv.options[this_selected_lv.selectedIndex].value;

  for (var i = 0; i < fakeJsonRespone.length; i++) {

    if (fakeJsonRespone[i].course_id == course_id) {

      var level_list = fakeJsonRespone[i].level_list;
      var list_question = document.getElementById('question_attribute_list_from_course_' + course_id);
      list_question.innerHTML = "";
      for (var j = 0; j < level_list.length; j++) {
        if (level_list[j].level_id == lv_selected) {
          var question_attribute_list = level_list[j].question_attribute_list;
          question_attribute_list.forEach(function (each_question_attibute_list) {
            var one_question = document.createElement('li');
            one_question.value = each_question_attibute_list.each_question_attibute_list;
            one_question.innerHTML = each_question_attibute_list.each_question_attibute_list;
            list_question.appendChild(one_question);
          });

          break;
        }
      }
      break;
    }
  }
};