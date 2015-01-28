
/**
 * 打印日志
 */
function log(message) {
	if (window.console && window.console.log) {
		window.console.log(message);
	}
}

//获得url路径
var contextPath = window.location.pathname.split("/")[1];
var basePath = window.location.protocol+"//"+window.location.host+"/"+contextPath;

/**
 * @author 孙宇
 * 
 * @requires jQuery
 * 
 * 将form表单元素的值序列化成对象
 * 
 * @returns object
 */
serializeObject = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};

