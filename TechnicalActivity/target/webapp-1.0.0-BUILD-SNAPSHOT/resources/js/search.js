function searchNumber() {
    // get the form values
    var name = $('#inputList').val();
    var education = $('#number').val();
    $.ajax({
        type: "POST",
        url: contexPath + "/search",
        data: "inputList=" + name + "&number=" + education,
        success: function(response){
            // check the response
            if(response.status == "SUCCESS")
            {            	             	
                 $('#successResult').html(response.result.number+"(nth) Maximum Number of the list ("+ response.result.inputList+") is : " + response.result.result);
                 $('#inputList').val('');
                 $('#number').val('');
                 $('#error').hide('slow');
                 $('#successResult').show('slow');
             }
             else if(response.status == "RETRY")
             {            	
                 $('#error').html("Please correct following errors: " + response.result);
                 $('#successResult').hide('slow');
                 $('#error').show('slow');
             }
             else
             {
                 errorInfo = "";
                 for(var i =0 ; i < response.result.length ; i++)
                 {
                     errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
                 }
                 $('#error').html("Please correct following errors: " + errorInfo);
                 $('#successResult').hide('slow');
                 $('#error').show('slow');
             }
         },
         error: function(e){
             alert('Error: ' + e);
         }
    });
}
