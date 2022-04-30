
//still an older way of doing things
function myFunc(vari){
	console.warn('The faeries are being scrambled!');
	console.warn(vari);
}



////THIS is how we should add events to html using javascript
/*there are MANY types of events in JS:
 * 	onsubmit, onchange, click, dblclick, mouseup, mousedown,
 * 	mouseenter, mouseleave, mouseover, mouseout, mousemove
 * 
 *  (mouseover includes children, mouseenter doesn't)
 *  (same with mouseleave and mouseout respectively)
 * 
 * 
 * 	there's also:
 * 		keyup, keydown, keypress, cut, paste, change(state change),
 * 		submit, etc
 * 
 */
let buttonOne = document.getElementById('button');
/*addEventListener(string, function)
 *   -the string will represent one of the various javascript events
 * 	 -the function will trigger every time the specified event has happened
 *     this type of function is called callback function. Callback functions
 *     are passed in a parameters to a "higher order" function.
 */
/*buttonOne.addEventListener('click', function (){
	console.log('in anony func');
});
*/
buttonOne.addEventListener('click', myFuncTwo /*myFuncTwo()*/);


function myFuncTwo(eve){
	console.log(eve);
	console.log("target: "+eve.target);
	console.log("clienty: "+eve.clientY);
	console.log("clientx: "+eve.clientX);
	console.log("offsety: "+eve.offsetY);
	console.log("altKey: "+eve.altKey);
}


//demo of a more complex event
let body=document.querySelector('body');
body.addEventListener('mousemove', myFuncFour);

function myFuncFour(eve){
	console.log(eve.type);
	body.style.backgroundColor= "rgb(" + eve.offsetX+ ","+
		eve.offsetY+ ", 40)";
}


