$(function(){
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	map.enableScrollWheelZoom(true);
	var point = new BMap.Point(114.060985,29.550939);
	map.centerAndZoom(point,15);
	var geoc = new BMap.Geocoder();    

	//标记位，让修改某个坐标不会触发增加事件
	var flag = false;
	
	var marker;
	
	map.addEventListener("click", function(e){   
		if (flag) {
			flag = false;
			return;
		}
		if (marker) {
			map.removeOverlay(marker);
			marker = null;
		}
		var pt = e.point;
		geoc.getLocation(pt, function(rs){
			var addComp = rs.addressComponents;
			$('#province').val(addComp.province);
			$('#city').val(addComp.city);
			$('#district').val(addComp.district);
			$('#street').val(addComp.street);
			$('#streetNumber').val(addComp.streetNumber)
			
			var addpoint = new BMap.Point(pt.lng, pt.lat);
			marker = new BMap.Marker(addpoint);
			map.addOverlay(marker);
			
			marker.addEventListener("click",function() {
				var p = marker.getPosition();  //获取marker的位置
				flag = true;
				alert("marker的位置是" + p.lng + "," + p.lat); 
			});
			
			log(pt.lng + "," + pt.lat + "," + addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
		});        
	});
	
	$("#saveBtn").bind('click', function() {
		var ff = serializeObject($("#shopForm"))
		log(ff);
	});
	
});


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
