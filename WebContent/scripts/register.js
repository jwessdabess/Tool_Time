function SetBilling(checked) {  
          if (checked) {  
                    document.getElementById('dStreet').value = document.getElementById('bStreet').value;   
                    document.getElementById('dCity').value = document.getElementById('bCity').value;   
                    document.getElementById('dState').value = document.getElementById('bState').value; 
					document.getElementById('dZip').value = document.getElementById('bZip').value;
          } else {  
					document.getElementById('dAddress').value = '';   
                    document.getElementById('dCity').value = '';   
                    document.getElementById('dState').value = '';   
                    document.getElementById('dZip').value = '';   
                    document.getElementById('dPhone').value = '';   
          }  
}   

    function Validate() {
        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }

function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split('&');
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split('=');
        if (decodeURIComponent(pair[0]) == variable) {
            return decodeURIComponent(pair[1]);
        }
    }
    console.log('Query variable %s not found', variable);
}

var parseQueryString = function( queryString ) {
    var params = {}, queries, temp, i, l;
    // Split into key/value pairs
    queries = queryString.split("&");
    // Convert the array of strings into an object
    for ( i = 0, l = queries.length; i < l; i++ ) {
        temp = queries[i].split('=');
        params[temp[0]] = temp[1];
    }
    return params;
};
	