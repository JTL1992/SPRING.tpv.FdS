tpv.service('busquedaDeArticulos', function ($http, $q) {
    "use strict";

    const urlBase = "http://localhost:8080/SPRING.tpv.FdS.1.2.0-SNAPSHOT/api/v0";


    this.request = function (config) {
        let deferred = $q.defer();
        $http(config).then(function (response) {
            deferred.resolve(response.data);
        }, function (response) {
            let errorMsg;
            if (response.data.error === undefined) {
                errorMsg = "";
            } else {
                errorMsg = " --- " + response.data.error + ":" + response.data.description;
            }
            deferred.reject(
                "Error (" + response.status + ":" + response.statusText + ")" + errorMsg);
        });
        return deferred.promise;
    }
    
        
 	var articles = {"code":200,"data":[

 		{
 			"id": 1,
 			"reference": "REFERENCE1",
 			"description": "DESCRIPTION 1",
 		},
 		{
 			"id": 2,
 			"reference": "REFERENCE2",
 			"description": "DESCRIPTION 2",
 		},
 		{
 			"id": 3,
 			"reference": "REFERENCE3",
 			"description": "DESCRIPTION 3",
 			
 		},
 		{
 			"id": 4,
 			"reference": "REFERENCE4",
 			"description": "DESCRIPTION 4",
 		}
 	]};
        
    
    /**
	 * TODO 
	 */
    this.getProducts = function (products) {
        let config = {
            method: 'POST',
            url: urlBase + "/articles/byFilter",
            data: products
        };
       return this.request(config);

        //return articles;
    }
	
	    

	  
}); 
