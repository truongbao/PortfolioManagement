// json mẫu nhận được khi ajax gửi request yêu cầu dữ liệu courses từ server xem ở trang dưới 
// http://jsoneditoronline.org/?id=8bc76a7b412279a8d1ad2e7c35ee85d2

// biến lưu trữ những spc mà người dùng đã chọn
var saveSPCSelected = [];

// spcList dùng chung
var saveListSPC = [];
// đối tượng lưu trữ lựu chọn của người dùng
function SpcSelected() {
    var spcId;
    var level;
}
// đối tượng gửi về RESTAIP
function ServicePortfolioCourseWrapper() {
    var spcourses = [];
}
// lưu trả database SPC lưu trử ở client

// bắt các sự kiện ở màn hình input spc
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
        var element = document.getElementById("SPCourseForm");
        element.innerHTML = "";
        spcs_change();


    });
    // validate Client
    $("#spc_insert_form").submit(function () {

        if (validateInsertSPCF() == 0) {
            event.preventDefault();
        }
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
        var spcList_length = spcList.length;
        for (var spcList_index = 0; spcList_index < spcList_length; spcList_index++) {
            var one_course_id = spcList[spcList_index];
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
        }
        saveSPCSelected = [];
        saveSPCSelected = saveChoose;
        // tiến hành kiểm tra spcs kiểm tra những id nào đã được lấy dữ liệu rồi


        for (var spcList_index = 0; spcList_index < spcList_length; spcList_index++) {
            var one_course_id = spcList[spcList_index];
            var one_sp_course_object = {};
            one_sp_course_object.id = one_course_id;
            var ck = 1;
            var saveListSPC_length = saveListSPC.length;
            for (var saveListSPC_index = 0; saveListSPC_index < saveListSPC_length; saveListSPC_index++) {
                var one_sp_course = saveListSPC[saveListSPC_index];

                if (one_course_id == one_sp_course.id) {
                    ck = 0;
                }
            }
            if (ck) spcs.push(one_sp_course_object);
        }
        spcWrap.spcourses = spcs;
    }
    return spcWrap;
};
// gửi yêu cầu dữ liệu đến server
// spList là danh sách id của spc cần lấy dữ liệu
// isLoad=0 thì chỉ lấy thông tin mà không hiển thị lên view
// isload=1 thì lấy thông tin và hiển thị lên view
function searchAjax(spcList, isLoad) {
    isLoad = isLoad || 1;
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
};

// lưu trữ dữ liệu thô (raw) nhận được từ server vào list để parse đối tượng đưa lên view
// data là chuỗi json trả về khi ajax nhận dữ liệu từ RESTFULAPI
function saveData(data) {
    var spcourses = data.spcourses;
    var spcourses_length = spcourses.length;
    for (var spcourses_index = 0; spcourses_index < spcourses_length; spcourses_index++) {
        var one_sp_course = spcourses[spcourses_index];
        saveListSPC.push(one_sp_course);
    }
};
//nhận dữ liệu và tiến hành khởi tạo các thẻ bằng DOM đưa lên view
//data là chuỗi json trả về khi ajax nhận dữ liệu từ RESTFULAPI
//level_seleted giá trị level mặc định hiển thị lên view 
function loadInfoFromSPC(data, level_seleted) {
    // khởi tạo giá trị mặc định cho level_selected
    level_seleted = level_seleted || 1;
    var element = document.getElementById("SPCourseForm");
    element.innerHTML = "";

    var index = -1;

    // loại bỏ những id trùng lặp
    var uSize = _.uniq(saveListSPC, function (p) { return p.id; });
    saveListSPC = uSize;

    var saveSPCSelected_length = saveSPCSelected.length;
    var saveListSPC_length = saveListSPC.length;

    for (var spc_sl_index = 0; spc_sl_index < saveSPCSelected_length; spc_sl_index++) {
        var saveSPC = saveSPCSelected[spc_sl_index];
        for (var saveListSPC_index = 0; saveListSPC_index < saveListSPC_length; saveListSPC_index++) {
            var one_sp_course = saveListSPC[saveListSPC_index];
            if (one_sp_course.id == saveSPC.spcId) {
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

                select_custom.setAttribute("onchange", 'list_lv_change(this,' + one_sp_course.id + ');');

                // create option inside select level
                var level_list_length = level_list.length;
                for (var level_list_index = 0; level_list_index < level_list_length; level_list_index++) {
                    var one_level = level_list[level_list_index];

                    var option = document.createElement("option");
                    option.value = one_level.level;
                    option.text = "パターン" + one_level.level;
                    if (option.value == saveSPC.level) {
                        option.selected = "true";
                    }
                    select_custom.appendChild(option);
                }
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
                load_list_level(saveSPC.level, one_sp_course.id);

            }

        }
    }
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
// sự kiện khi người dùng thay đối level của 1 spc
// this_selected_lv là đối tượng tag select bị thay đổi -> nhận dc level thay đối level
// spcourse_id là id của khóa học có level bị thay đổi
function list_lv_change(this_selected_lv, spcourse_id) {
    var lv_selected = this_selected_lv.options[this_selected_lv.selectedIndex].value;
    for (var i = 0; i < saveSPCSelected.length; i++) {
        if (saveSPCSelected[i].spcId == spcourse_id) {
            saveSPCSelected[i].level = lv_selected;
        }
    }
    load_list_level(lv_selected, spcourse_id);
};
// hàm này load lại question atribute dựa vào level và id của spc do người dụng chọn
// level_seleted level của khóa học được chọn
// spcourse_id là id của khóa học bị thay đổi
function load_list_level(level_seleted, spcourse_id) {
    var saveListSPC_length = saveListSPC.length;
    for (var saveListSPC_index = 0; saveListSPC_index < saveListSPC_length; saveListSPC_index++) {
        var one_sp_course = saveListSPC[saveListSPC_index];

        if (one_sp_course.id == spcourse_id) {
            var list_question = document.getElementById('question_attribute_list_from_spcourse_' + spcourse_id);
            list_question.innerHTML = "";
            var level_list = one_sp_course.level_list;
            var level_list_length = level_list.length;
            for (var level_list_index = 0; level_list_index < level_list_length; level_list_index++) {
                var one_level = level_list[level_list_index];
                if (one_level.level == level_seleted) {
                    var question_attribute_list = one_level.question_attribute_list;
                    var q_a_l_length = question_attribute_list.length;
                    for (var q_a_l_index = 0; q_a_l_index < q_a_l_length; q_a_l_index++) {
                        var each_question_attibute_list = question_attribute_list[q_a_l_index];
                        var one_question = document.createElement('li');
                        one_question.innerHTML = each_question_attibute_list.question_attribute_name;
                        list_question.appendChild(one_question);
                    }
                }
            }
        }
    }
}


// validate form in client
function validateInsertSPCF() {
    return validateSPCName() * validateNumberSPCName();
}

/**
 * hàm này hiển thị lỗi nếu người dụng để trống tên hoặc nhập tên >32 kí tự
 */
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
// hàm này kiểm tra số lượng tối thiểu và tối đa khi cài đặt SPC
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

