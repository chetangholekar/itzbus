    function getVRLSourceStation() 	
	{
		ItzBus.getVRLStationList(createVRLSourceStation);
	}
	function createVRLSourceStation(station_name) 
	{   
		var source_station = DWRUtil.getValue("source_station");
		DWRUtil.removeAllOptions("source_station");
  		DWRUtil.addOptions("source_station",station_name);
  		DWRUtil.setValue("source_station",source_station);
  		if(source_station != 'null'){
  			getVRLDestinationStation();
  		}
  	}
	
	function getVRLDestinationStation() 	
	{
		var sourceStation = DWRUtil.getValue("source_station");
		ItzBus.getVRLDestinationStationList(createVRLDestinationStation,sourceStation);
	}
	function createVRLDestinationStation(station_name) 
	{   
		var dest_station = DWRUtil.getValue("dest_station");
		DWRUtil.removeAllOptions("dest_station");
	  	DWRUtil.addOptions("dest_station",station_name);
	  	DWRUtil.setValue("dest_station",dest_station);
	}
	
	