<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

            <div class="main-content" id="portfolio">
                    <h1 class="main-heading">ポートフォリオ用科目設定画面</h1>
                    <div class="main-summary portfolio-unit">
					
					
                        <form class="form-horizontal" action="/action_page.php">
                            <div class="form-group">          
                                <label class="control-label col-sm-2 label_69">現行設定</label> 
                                <div class="col-sm-5">
                                     <input type="text" class="form-control" value=""> 
                                </div>
                            </div>
                            <div class="form-group">                                
                                <label class="control-label col-sm-2 label_69">対象グループ</label> <!--tên quản lý-->  
                                <div class="col-sm-10">
                                        <table class="table table-blue table_portfolio_groups">
                                                <thead>
                                                    <tr>
                                                        <th class="group_secern_name">種別</th>
                                                        <th class="group_name">項目</th>                                                            
                                                    </tr>
                                                </thead>
                                                <tbody>                                                                       
                                                    <tr>
                                                            <td class="group_height td_69">クラス</td>
                                                            <td class="group_height group_list">    
                                                                    <select name="group_id[]" class="custom_select">
                                                                        <option value="january" rel="icon-temperature">クラス</option>
                                                                        <option value="hide">学生</option> 
                                                                        <option value="february">志望分野</option>
                                                                        <option value="march">大学種別</option>
                                                                    </select> 
                                                            </td>
                                                    </tr>
                                                    <tr>
                                                            <td class="group_height td_69">クラス</td>
                                                            <td class="group_height group_list">    
                                                                    <select name="group_id[]" class="custom_select">
                                                                        <option value="january" rel="icon-temperature">クラス</option>
                                                                        <option value="hide" >学生</option> 
                                                                        <option value="february">志望分野</option>
                                                                        <option value="march">大学種別</option>
                                                                    </select> 
                                                            </td>
                                                    </tr>                                          
                                                </tbody>
                                        </table>
                                </div>
                            </div>    


							
                            <div class="form-group">          
                                <label class="control-label col-sm-2 label_69">対象科目</label> 
                                <div class="col-sm-3 list_course">
                                        <select multiple="multiple" class="form-control">
                                                <option value="1">コースA</option>
                                                <option value="2">コースB</option>
                                                <option value="3">コースC</option>
                                                <option value="4">コースD</option>
                                        </select>
                                </div>
                            </div>    
							
							
                            <div id="coursr_list" class="row">
                                    <h1 class="one_course_name">コースA</h1>       
                                    <div class="form-group">          
                                            <label class="control-label  col-sm-2 col-sm-offset-2 label_69">単元タグ設定パターン</label> 
                                            <div class="col-sm-4 level_list">
                                                    <select class="custom_select_level">
                                                            <option value="january" rel="icon-temperature">クラス</option>
                                                            <option value="hide">学生</option> 
                                                            <option value="february">志望分野</option>
                                                            <option value="march">大学種別</option>
                                                    </select> 
                                            </div>
                                    </div>
                                    <div class="form-group">          
                                            <label class="control-label col-sm-2 col-sm-offset-2 label_69">単元タグ</label> 
                                            <div class="col-sm-8">
                                                    <ul class="patern_list">
                                                        <li>単元タグ</li>
                                                        <li>単元タグ</li>
                                                        <li>単元タグ</li>
                                                    </ul>
                                            </div>
                                    </div>
                            </div>
                            <div id="coursr_list" class="row">
                                        <h1 class="one_course_name">コースB</h1>       
                                        <div class="form-group">          
                                                <label class="control-label  col-sm-2 col-sm-offset-2 label_69">単元タグ設定パターン</label> 
                                                <div class="col-sm-4 level_list">
                                                        <select class="custom_select_level">
                                                                <option value="january" rel="icon-temperature" >クラス</option>
                                                                <option value="hide" >学生</option> 
                                                                <option value="february">志望分野</option>
                                                                <option value="march">大学種別</option>
                                                        </select> 
                                                </div>
                                        </div>
                                        <div class="form-group">          
                                                <label class="control-label col-sm-2 col-sm-offset-2 label_69">単元タグ</label> 
                                                <div class="col-sm-8">
                                                        <ul class="patern_list">
                                                            <li>単元タグ</li>
                                                            <li>単元タグ</li>
                                                            <li>単元タグ</li>
                                                        </ul>
                                                </div>
                                        </div>
                                </div>
                            <div class="btn-management">
                                    <button class="btn btn-blue-dark btn-w190">更新</button>
                            </div>
                            
                         </form>
                            
                    </div>
                </div>
                
                