$(function(){
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	map.enableScrollWheelZoom(true);
	var point = new BMap.Point(114.060985,29.550939);
	map.centerAndZoom(point,15);
	var geoc = new BMap.Geocoder();    
	
	
	var addMarker = function(marker,data){
		 marker.addEventListener("click",function() {
			 if (_marker === this) {
				 log("你点击了没有保存的点");
				 //需要添加
				 return;
			 }
			 //需要获取已经保存的点的详细信息
			var p = this.getPosition();  //获取marker的位置
			flag = true;
			if (data) {
				setForm($("#shopForm"),data);
			}
		});
		map.addOverlay(marker);
		//创建右键菜单
		var markerMenu=new BMap.ContextMenu();
		markerMenu.addItem(new BMap.MenuItem('删除',removeMarker.bind(marker)));
		marker.addContextMenu(markerMenu);
	}
	
	//删除标记
	var removeMarker = function(e,ee,marker){
		if (marker.shopId) {
			log("删除已添加的点" + marker.shopId);
			$.ajax({
				type : "post",
				url : basePath + "/shops/shopsController/deleteShop",
				dataType : "json",
				data : {id : marker.shopId},
				success : function(ret) {
					if (ret.success) {
						showLog(ret.msg);
						map.removeOverlay(marker);
					} else {
						showLog(ret.msg);
					}
					
				}
			});
		} else {
			log("删除没有添加的点.....");
			map.removeOverlay(marker);
		}
		
	}

	//标记位，让修改某个坐标不会触发增加事件
	var flag = false;
	
	//记录当前点击的标记，为了让没有保存的点，在点击其他地方时删除该点
	var _marker = null;
	
	//地图加载完成
	map.addEventListener("tilesloaded",function(){
		$.ajax({
			type : "get",
			url : basePath + "/shops/shopsController/list",
			dataType : "json",
			data : {},
			success : function(ret) {
				if (ret.success) {
					var allData = ret.obj;
					for (var i=0;i<allData.length;i++) {
						var point = new BMap.Point(allData[i].lng,allData[i].lat);
						var marker = new BMap.Marker(point);
						//自定义一个id属性
						marker.shopId = allData[i].id;
						addMarker(marker,allData[i]);
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
			_marker = new BMap.Marker(addpoint);
			addMarker(_marker);
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
	
	//验证输入内容
	 $('#shopForm').bootstrapValidator({
//       live: 'disabled',
       message: '输入内容有效',
       feedbackIcons: {
           valid: 'glyphicon glyphicon-ok',
           invalid: 'glyphicon glyphicon-remove',
           validating: 'glyphicon glyphicon-refresh'
       },
       fields: {
    	   shopName: {
               validators: {
                   notEmpty: {
                       message: '商铺名称不能为空'
                   }
               }
           },
           businessSign: {
               validators: {
                   notEmpty: {
                       message: '营业牌照不能为空'
                   }
               }
           },
           lessor: {
               validators: {
                   notEmpty: {
                       message: '出租人不能为空'
                   }
               }
           }
       }
   });
	
});

function showLog(msg) {
	$(".modal-body").html(msg);
	$('#myModal').modal({
		backdrop : "static",
		show : true
	});
}


