var oTableTools = {"sRowSelect": "single",
				"aButtons": []};
$('#example').dataTable({
			"bFilter":false,
			"bSort":true,			
			"bProcessing" : true,
			"bServerSide" : true,
			"bRetrieve"   : true,		
			"sAjaxSource" : "/City/returnCityList",
			"oTableTools":  oTableTools,
			"sServerMethod":"POST",
			"aoColumns" : [
			      {"mData" : "id", "bSearchable": false, "bSortable" : false}	
			     ,{"sName":"cityName", "mData" : "cityName", "sClass":"align-center","bSearchable": false,"sDefaultContent" : "", "bSortable" : true }
	             ,{"sName":"createTime", "mData" : "createTime", "sClass":"align-center","bSearchable": false,"sDefaultContent" : "", "bSortable" : true}
	             ],
	    "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull) {
	    		var id = aData.id;
		    	$(nRow).attr("id", id);
                var oSettings = this.fnSettings();
		        if(oSettings.oFeatures.bServerSide) {
		    	   $("td:first", nRow).html(oSettings._iDisplayStart + iDisplayIndex + 1);
		       } else {
		    	   $("td:first", nRow).html(iDisplayIndexFull + 1);
		        }
		        var operate="操作";
		        $("td:last", nRow).html(operate);
	    },
		    "fnDrawCallback" : function() {
		    	bindClick();
			}
		});
function bindClick(){
       
}