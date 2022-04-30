/*
 * What is AJAX?
 * 	-Asynchronous Javascript and XML
 * What does this mean?
 * 	Asynchronous means that the actions of this thread do not
 *  block the actions of other threads. "Non-blocking".
 * Why XML?
 * 	Because it originally just used XML. But has evolved. 
 * 	Nowadays we will be using JSON majority of the time.
 */

window.onload = function (){
	document
		.getElementById('swSubmit')
		.addEventListener('click', getSW);
}

function getSW(){
	//console.log("get sw is working!");
	
	//get the value from the field
	let swId = document.getElementById('swId').value;
	
	
	//STEP 1: create the XMLHttpRequest object
	//this object allows us to make requests and get back data.
	// in short, this is our data retriever (it calls an API)
	let xhttp = new XMLHttpRequest();
	
	/*
	 * READY STATE
	 * 		State 0: not initialized
	 * 		State 1: server connection established
	 * 		State 2: request received
	 * 		State 3: processing request
	 * 		State 4: complete, request finish and response is ready
	 */
	
	//STEP 2: create the callback function for readystate changes
	xhttp.onreadystatechange = function (){
		//console.log("ready state is changing! "+xhttp.readyState);
		
		if(xhttp.readyState==4 && xhttp.status==200){
			//console.log("state 4!");
			
			//this parse function turns a JSON into a javascript object
			let sw = JSON.parse(xhttp.responseText);
			
			console.log(sw);
			
			setValues(sw);
		}
	}
	
	//STEP 3: create and open a connection
	//xhttp.open(http method, url)
	xhttp.open("GET", 'https://swapi.co/api/people/'+ swId);
	
	//STEP 4: send the request
	xhttp.send();
	
}


function setValues(sw){
	document.getElementById('swName').innerHTML = sw.name;
	document.getElementById('swBirthYear').innerHTML = sw.birth_year;
}





