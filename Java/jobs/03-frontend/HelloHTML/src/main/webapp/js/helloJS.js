/**
 * What is the DOM?
 * -Document Object Model
 *  - The DOM is a virtual representation of the HTML page
 */

//console.log("We have functioning javascript in a separate file!")
//did you notice a semi colon? nope!
// Javascript doesn't need semi colons...but it is bad practice to leave them
//    out.

//console.log('quick message');
//did you notice the single quotes?   you may use single or double quotes
//console.log("look at these single quotes 'hi!' see?");

//an alert summons a small window that pauses the javascript until
//   the user clicks a button.
//alert("look at this alert!");
//console.log("after the alert");


////////////PRIMITIVE DATATYPES in javascript
//		number, string, boolean, null, undefined, symbol
var num= 5;	//number
var numTwo;		//is undefined
//numThree would be undeclared
var name="Aster 'The Raver'";	//string
var isApproved= false;	//boolean, can be true or false
var noMansLand= undefined; //undefined
var noObj= null;	//

//now go to the browser and use "typeof" in the console on the variables.
//we can also attempt to dynamically reassign a var to a diff type


/*
 * time for a console == demo
 * 		a double equals, or comparison, checks if the two values are equal
 *   		(with type coercion) then produces a true or false value
 *   
 *  time for a console === demo
 *  	a triple equals, or strictly comparison, checks if two values
 *  	have the same datatype AND value, then produces a true or false
 */

//backtiks aka template literals
var tempNum= 25;
var longString= 'Printing ${80+250}longString: ' + tempNum +
	' and now that we have that...theres more' +
	' and some more stuff ' + tempNum+ ' we are talking about ' +
	' and again with the talking' +
	' is anyone '+ tempNum + ' annoyed yet?';

var longStringTwo=`Printing longString: ${tempNum}
		and now we have some more nonsense ${80+250}
			and then some other stuff, I have a lot
			of typos going today. even as
			i type here and now
			or something....whatever
			${"look at me" +15}`;

//console.log(longString);
//console.log(longStringTwo);

////REFENCED TYPES
//			objects, functions, array

var exArray = ['Billy', 'Lankey'];   //array

//function
function exFunc(){
	//this is where the snippet of code will be
		console.log("we're in the function example");
}

//exFunc(); //this is how you invoke a function
//console.log(exFunc); //this will print out the function declaration

var exObj ={
		name: 'Danny Boy',
		ability: 'electromagnetism',
		'bounty': 250000
}

//console.log(exObj);
//console.log(exObj.ability);
//console.log(exObj.bounty);
//console.log(exObj["ability"]);
//console.log(exObj[1]); //won't work with a number index

/*How is using exObj["name"] useful?
 * 
 * 	Let's say you have a key that is 'y2.k-18'. It has various symbols
 *  square brackets suddenly become useful.
 *  	var keyName= 'y2.k-18;
 *  	exObj[keyName];
 */

//objects and their dynamic nature
//will this work?
//console.log(exObj.role); //this will be undefined

////let's try it THIS way
exObj.role = 'Mob Boss';
//console.log(exObj.role);

delete exObj.bounty;
exObj.myMethod=exFunc;
//console.log(exObj);

//these two below do the same thing
//exObj.myMethod();
//exFunc();


var arrayOfDoggos=['doge', 'pupper', 'doggo', 'scrappy', 'goodestboi'];
//console.log(arrayOfDoggos);
//console.log(arrayOfDoggos[1]);

//console.log(arrayOfDoggos[7]);

arrayOfDoggos[7]='does this work?';
//console.log(arrayOfDoggos[7]);
//console.log(arrayOfDoggos[6]);
// and yes you CAN do multi dimensional array


//this is an empty array
var emptyArray= [];
//this is an empty object
var emptyObject={};


/////FUNCTION
function myFuncTwo(pokemans, strength){// <---this is the parameter list
	console.log("the best pokemon is: "+pokemans + strength);
}

//myFuncTwo("Starmie", 17);//<---this is the argument list
//myFuncTwo("Onix", 100);

///////SCOPES
/*
 * What are the scopes in javascript?
 * 		global, function, block
 *   Global scope: the variable can be accessed by everything
 *   Function scope: only accessible within the specific function
 *   Block scope: only accessible within the block it is defined.
 *   
 * How do we declare varibles in javascript?
 *  we can use "var", "let", and "const". You can also not use one of these
 *  keywords.
 *  
 *  var only enforces the global and function scopes.
 *  let and const enforce global, function, AND block.
 *  
 *  const means the value can't be changed once it has been set
 */
var myGlobalScope= 77;
//console.log(myGlobalScope);


function myFunction(){
	var myFunctionScope=18; //function scoped
	console.log("in the function: "+myFunctionScope);
	
	//without the "var" keyword when this line is run it will become a
	// global variable. If you DON'T run this method first, it will not
	//  be declared
	otherVar=19; //this is global
	
	if(true){
		let myBlockScope= 66;
		myBlockScope='the';
	}
	console.log(myBlockScope);
}
//myFunction();

//console.log(myFunctionScope);
//console.log(otherVar);


//CONDITIONS
function myFuncFive(myBool){
	if(myBool){
		console.log("IT WORKED!");
	}else if (!myBool){
		console.log(":( sad face");
	}
}
//myFuncFive(function newFunc(){ return 0});
/*false?
 * 	false, 0, "" the empty string, null, undefined, NaN
 * THESE are the falsey values
 * 
 * true?
 * 	true, not 0, non empty string, and yes....even functions
 */


//HOISTING?
/*Hoisting - all declarations will be processed before all other lines
 * of code. This allows you to call variables and functions before they are
 * declared.
 */
//myFunc8(); //we can do this because it has been hoisted
function  myFunc8(){
	console.log("in func 8");
}






//CONTROL FLOW
function myFuncFour(){
	/*
	 * in js types of control flow include:
	 * 		if-elseif-else, switch, while loop, do while loop,
	 * 		for loop, for each loop, ternary statement
	 * 
	 * And yes, labels exist in javascript
	 */
	
	let myArr= [88, "Danny Boy", true, "blue", 22, "hike!"];
	let myObjee= {"element1": 66, "element2": "one line, really?"};
	
	//but FOR LOOPS are worth looking into the new syntax
	
	//"for of" loop
	//for of loop will retrieve each element
	/*for(let temporary of myObjee){
		console.log(temporary);
		//will not function correctly, objects not iterable
	}*/
	
	//"for in" loop
	//  will retrieve each index
	for(let temporary in myObjee){
		console.log(temporary);
		//will work with objects as well as arrays
	}
}
//myFuncFour();

/// we will not do an example of prototypical inheritance but you could
// look into it. This is just a note of the conversation we had in training




//////MORE WITH FUNCTIONS
//return in a function
function returnExample(){
	//return "this stuff";
	//return 5;
	//you don't need to declare a return type, simply return what you want
}

//what happens if I don't return anything?
//console.log(returnExample()); //undefined with no return


//WHAT IS.....an anonymous function?
// a function without a name
let funcHolder = function(){
	console.log("in the anonymous function?");
}
//funcHolder();
let newHolder= funcHolder;
funcHolder= null;
//newHolder();

//another example of an anonymous function
function anonymousInvoker(temp){
	temp();
}
//anonymousInvoker(function(){console.log("what is even happening?");});
/*
 * A callback function is a function passed into ANOTHER function as a
 *  parameter to be called later.
 * A higher order function is the OTHER function that accepts callback
 * 	functions as parameters
 */



//What is a self-invoking function?
//	a function that calls itself
/*(function (aParam){
	console.log("in self invoking function: "+aParam);
})("what even is this?");*/



//nested functions
//   a function in a function
function birdNest(){
	let ourVar=7;
	
	babyBird(); //yes, hoisting still works
	function babyBird(){
		let ourOtherVar=15;
		console.log("babybird(): "+ ++ourVar);
	}
	babyBird();
	//console.log(ourOtherVar); //will not work
}
/*birdNest();
birdNest();
birdNest();
birdNest();*/


//////////CLOSURE
//what is closure?
// answer:

let foo= (function (){
	let bar= 0;
	return function(){
		return ++bar;
	};
})();

/*console.log(foo);
console.log(foo());
console.log(foo());
console.log(foo());
console.log(foo());*/


////ERROR in javascript
//throw new Error("This Peter is invalid");
//console.log("stuff!");


//////ARROW NOTATION (function shorthand notation)
/*
 * another way to create a function
 * (a,b) => a+b;  //this WILL return a+b implicitly
 * OR   (a,b) => {a+b; console.log(a+b);}
 */
let arrowExample = (numba) => numba+1;/*{
	console.log("numba "+ numba);
	console.log("Abigail");
}*/
console.log(arrowExample(5));












































