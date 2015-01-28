$(function(){
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	map.enableScrollWheelZoom(true);
	var point = new BMap.Point(114.060985,29.550939);
	map.centerAndZoom(point,15);
	var geoc = new BMap.Geocoder();    
	
	var addMarker = function(marker){
		 marker.addEventListener("click",function() {
			 log("_marker" + _marker);
			 if (_marker == marker) {
				 log("你点击了没有保存的点");
			 }
			 
			var p = marker.getPosition();  //获取marker的位置
			flag = true;
			alert("marker的位置是" + p.lng + "," + p.lat); 
		});
		map.addOverlay(marker);
	}

	//标记位，让修改某个坐标不会触发增加事件
	var flag = false;
	
	//记录当前点击的标记，为了让没有保存的点，在点击其他地方时删除该
	var _marker;
	
	//地图加载完成
	map.addEventListener("tilesloaded",function(){
		$.ajax({
			type : "get",
			url : basePath + "/shops/shopsController/list",
			dataType : "json",
			data : {},
			success : function(ret) {
				if (ret.success) {
					var allData = ret.obj
					for (var i=0;i<allData.length;i++) {
						var point = new BMap.Point(allData[i].lng,allData[i].lat);
						var marker = new BMap.Marker(point);
						addMarker(marker);
					}
					return;
				}
				showLog(ret.msg);
			}
		});
	});
	
	//地图点击事件
	map.addEventListener("click", function(e){   
		if (flag) {
			flag = false;
			return;
		}
		if (_marker) {
			map.removeOverlay(_marker);
			_marker = null;
		}
		var pt = e.point;
		geoc.getLocation(pt, function(rs){
			var addComp = rs.addressComponents;
			$('#province').val(addComp.province);
			$('#city').val(addComp.city);
			$('#district').val(addComp.district);
			$('#street').val(addComp.street);
			$('#streetNumber').val(addComp.streetNumber);
			$('#lng').val(pt.lng);
			$('#lat').val(pt.lat);
			
			var addpoint = new BMap.Point(pt.lng, pt.lat);
			marker = new BMap.Marker(addpoint);
			addMarker(marker);
			log(pt.lng + "," + pt.lat + "," + addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
		});        
	});
	
	//添加新的商铺
	$("#saveBtn").bind('click', function() {
		var data = serializeObject($("#shopForm"))
		$.ajax({
			type : "post",
			url : basePath + "/shops/shopsController/addShop",
			dataType : "json",
			data : data,
			success : function(ret) {
				if (ret.success) {
					showLog(ret.msg);
					_marker = null;
					$('#shopForm')[0].reset(); 
					return;
				}
				showLog(ret.msg);
			}
		});
	});
	
	$("#testBtn").bind("click", function(){
		$('#myModal').modal("show");
	});
	
});

function showLog(msg) {
	$(".modal-body").html(msg);
	$('#myModal').modal({
		backdrop : "static",
		show : true
	});
}


