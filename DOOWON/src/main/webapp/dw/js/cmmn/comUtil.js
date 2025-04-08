/*
*	Common validation check function, main import
*/

//validation check function only 문자열의 최대길이 값을 파라미터로 받아서 처리
function notEmpty(value, maxLength){
	if(value == null || value == ""){
		return false;
	}
	if(((String(value)).trim()).length > 0 && ((String(value)).trim()).length <= maxLength){
		return true;
	} else {
		return false;
	}
}

// validation check
function lengthcheck(value, maxLength){
	if(value == null || value == ""){
		return true;
	} else if(value.length > maxLength){
		return false;
	} else {
		return true;
	}
}


//date validation check function
var dateChcek = function(value, callback){
	if(!value ){
		callback(true);
		return;
	}
	var dateForm = dateFormChange(value.replaceAll("/", ""))
	var re = /[0-9]{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])/;
	if(!re.test(dateForm) || String(dateForm.trim()).length == 0 || String(dateForm.trim()).length != 8){
		callback(false);
	}else{
		callback(true);
	}
}

var notEmptyDataCheck = function(value, callback){
	value = value.replace(/\-/gi, '')
	if(value == null || value ==""){
		callback(false);
		return;
	}
	var dateForm = dateFormChange(value.replaceAll("-", ""))
	var re = /[0-9]{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])/;
	if(!re.test(dateForm) || !value || String(dateForm.trim()).length == 0 || String(dateForm.trim()).length != 8){
		callback(false);
	}else{
		callback(true);
	}
}

//End date validation check function
function fn_strtEdtDtCheck(sVal, eVal){
	var re = /[0-9]{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])/;
	if(edDt && stDt){
		var edDt = dateFormChange(eVal.replaceAll("/", ""));
		var stDt = dateFormChange(sVal.replaceAll("/", ""));
		if(!re.test(edDt) || !edDt || String(edDt.trim()).length == 0 || String(edDt.trim()).length != 8){
			return false;
		} else {
			if(Number(stDt) <= Number(edDt)){
				return true;
			} else {
				return false;
			}
		}
	} else {
		return true;
	}
}

//validate if the start date is smaller than the end date and if either the start date or end date is null.
function fn_validateSearchDate(strtDt, endDt){
	var strtDt = parseInt(dateFormChange(strtDt.replace(/\//gi,'')));
	var endDt = parseInt(dateFormChange(endDt.replace(/\//gi,'')));
	
	var nowdate = new Date();
    var year = nowdate.getFullYear();
    var month = ("0" + (1 + nowdate.getMonth())).slice(-2);
    var day = ("0" + nowdate.getDate()).slice(-2);

    var date = parseInt(year + month + day);
	
	if(strtDt > endDt) {
		alert(msgdateComparison);
		return "false";
	} 
	return "true";
}

//date form change function VN, EN, KR
function dateFormChange(value) {
	var yy;
	var mm;
	var dd;
	var date;
	date = value;
	/*if(colLang == 'vt') {
		yy = value.substr(0,4);
		mm = value.substr(4,2);
		dd = value.substr(6,2);
		date = yy+mm+dd;
	} else if(colLang == 'en'){
		yy = value.substr(0,4);
		mm = value.substr(4,2);
		dd = value.substr(6,2);
		date = yy+mm+dd;
	} else{
		date = value;
	}*/
	return date;
}

//SelectBox validation check function
function emptySelectboxCheck(value, selOption){
	if(!value || value.length == 0){
		return true;
	}
	if (value.length > 50 || $.inArray(value, selOption) < 0) {
		return false;
	}else{
		return true;
	}
}

//SelectBox validation check function
function selectboxCheck(value, selOption){
	if (!value || String(value.trim()).length == 0 || value.length > 50 || $.inArray(value, selOption) < 0) {
		return false;
	}else{
		return true;
	}
}


//replaceAll change
String.prototype.replaceAll = function(org, dest) {
    return this.split(org).join(dest);
}

//언어별 날짜
function fn_gFmtDate(param1, param2){
	var result = "";
	if(param1 != undefined && param1 != '' && param1 != null){
		var date = new Date(param1)
	} else {
		var date = new Date();
	}
	
	var year = date.getFullYear()-param1;
	var month = date.getMonth()+1;
	var date = date.getDate();

	result = year + param2 + fn_addString(month) + param2 + fn_addString(date);
	/*if(colLang == "vt"){
		result = year + param2 + fn_addString(month) + param2 + fn_addString(date);
		result = fn_addString(date) + param2 + fn_addString(month) + param2 + year;
	}else if(colLang == "en"){
		result = year + param2 + fn_addString(month) + param2 + fn_addString(date);
		result = fn_addString(month) + param2 + fn_addString(date) + param2 + year;
	}else{
		result = year + param2 + fn_addString(month) + param2 + fn_addString(date);
	}*/

	return result;
};

function fn_addString(data){
	if(data.toString().length == 1){
		data = "0" + data;
	}
	return data;
};

//날짜 입력 시 /표시
function fn_dateInputForm(target){
	var date = target.val();
	date = date.replace(/-/gi,''); // 슬래시를 대시로 변경

	if (date.length > 4) {
	    if (date.length > 6) {
	        if (date.length === 8) { // '='를 '==='로 수정하여 비교 연산을 정확하게 합니다.
	            return target.val(date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8));
	        }
	        return target.val(date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6));
	    }
	    return target.val(date.substring(0, 4) + "-" + date.substring(4));
	}
	
}


//날짜 입력 시 /표시
function fn_dateColForm(target){
	var date = target;
	if(date != undefined && date != null && date.length != ''){
		date = date.replace(/\//gi,'');
	} else {
		return target;
	}
	
	if(date.length > 4){
		if(date.length > 6){
			if(date.length = 8){
				return (date.substring(0,4) + "-" + date.substring(4,6) + "-" + date.substring(6,8));
			}
			return (date.substring(0,4) + "-" + date.substring(4,6) + "-" + date.substring(6));
		}
		return (date.substring(0,4) + "-" + date.substring(4));
	}
}

//hs 정합성 체크
function fn_hsCdCheck(value, callback, col, row, hot){
	if(value == null || value == ""){
		callback(true);
		return;
	}

	var reg = /^[0-9]*$/;
	value = value.replace('.', '');
	value = value.replace('-', '');
    if((reg.test(value) && value.length <= 10 )|| value == null ||  value.length == 0){
    	callback(true);
    }else{
    	callback(false);
	}
}

//hs 6단위 정합성 체크
function fn_hsCd6Check(value, callback, col, row, hot){
	var reg = /^[0-9]*$/;
	value = value.replace('.', '');
	value = value.replace('-', '');
    if((reg.test(value) && value.length == 6 )&& value != null &&  value.length != 0){
    	callback(true);
    }else{
    	callback(false);
	}
}


//HS VER 체크
var fn_hsVerCheck = function(value, callback, col, row, hot){
	var regexp = /^[0-9]*$/;
	if(String(value).length == 4 && regexp.test(String(value)) ){
		callback(true);

	}else{
		callback(false);
	}
}

//hsCd form생성 공통 함수
function fn_hsCdForm(hsCd) {
	tempHsCd = ((hsCd.replace('.', '')).replace('-', ''));
	if(tempHsCd > 10) {
		tempHsCd = tempHsCd.substring(0,10);
	}
	if(String(hsCd).replace('.', '').length > 6){
		hsCd = tempHsCd.substring(0, 4) + "." + tempHsCd.substring(4,6) + "-" + tempHsCd.substring(6);
	}else if (String(hsCd).replace('.', '').length > 4) {
		hsCd = tempHsCd.substring(0, 4) + "." + tempHsCd.substring(4);
	}
	return hsCd;
}

//정수값 체크
var fn_positive = function(value, callback, col, row, hot){
	if(value == null){
		return callback(false);
	}
	value = Number((value+"").replace(/,/gi, ""))
	if(value < 0 || isNaN(value)){
		callback(false);
	}else{
		callback(true);
	}
}

//톻화단위 또는 수량에대한  format함수
function fn_numericFormat(value){
	var parts = value.toString().split("."); 
	return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (parts[1] ? "." + parts[1] : "");
}

function fn_loading(type){
	if(type){
		$(".loading-back").show();
	} else {
		$(".loading-back").hide();
	}
}

