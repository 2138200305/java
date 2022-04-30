//console.log("it is connected properly");

//console.log(document);
//console.log(document.URL);
//console.log(document.title);
//console.log(document.all);
/*console.log(document.links);
 * console.log(document.images);
 * console.log(document.forms);
 */


//even though this works THIS time...if we put more elements into the html
//page then the index will change. This isn't a stable solution.
//document.all[11].innerText="wait, html elements have mailmen?";



//////GET ELEMENT BY ID
let paraTwo= document.getElementById('para2');
//these two don't process tags
//paraTwo.textContent="Things are <b>going horribly</b> wrong! PANIC!";
//paraTwo.innerText='im not gonna<b> let this</b> run my day!'

//we can inject html tags into innerHTML
//paraTwo.innerHTML='im not gonna<b> let this</b> run my day!'


////////GET ELEMENT BY CLASS NAME
let muffins= document.getElementsByClassName("headers");
//console.log(muffins);

muffins[1].textContent="Blueberry Muffins";
muffins[1].style.fontWeight="normal"; //normal or bold or a value
	
	
////////GET ELEMENT BY TAGNAME!
//getElementsByTagName('');
// basically, the same as elements by class name
	


/////////QUERY SELECTORS!!!!!
//css selectors
//	"#" prefix for id, '.' prefix for class, no prefix for a tag

//for id demo
/*let selection= document.querySelector('#para2');
selection.innerHTML="blah blah blah";*/

//for classes demo
/*//if you don't use querySelectorAll then it will find the first valid element
let selection= document.querySelector('.headers');
 
let selection= document.querySelectorAll('.headers');
//selection[0].innerHTML="blah blah TITLE blah";
for(let i=0; i<2; i++){
	selection[i].innerHTML="blah blah TITLE blah";
}
*/


//you can also use select in the following ways:
//  last-child, first-child, nth-child(n)
let selectionTwo= document.querySelector('.para:nth-child(1)');
selectionTwo.innerText="nth child";


///NAVIGATING THE DOM
//you can also use stuff like
/*	.parentNode/.parentElement
	.childNodes/ .childElements
	.firstChild/ .lastChild
	.firstElementChild/.lastElementChild
	
	also, next and previous siblings
*/

/////////CREATE ELEMENTS
//creating our new element
let newDiv = document.createElement('div');
//populate our new element with attributes
newDiv.id="newestDiv";
newDiv.setAttribute('title', 'div show or somethin');

console.log(newDiv);

//creating a text node, then appending to our new div element
let divText= document.createTextNode('new text node riiiiight here');
newDiv.appendChild(divText);

//appending our new div element onto an existing element that is currently
//  inside of the DOM
let newSelection= document.querySelector('#para1');
newSelection.appendChild(newDiv);

//////DELETE
//////removeAttribute, removeChild, remove







