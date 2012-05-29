/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var counter = 1;
var windowCounter = 1;
/**
 * add new surface to form
 */
function addSurface() {
    var form = document.getElementById("unitFormID");
    var newElement = document.createElement('div');
    newElement.setAttribute('class','surfaceForm')
    newElement.setAttribute('id', 'Element'+counter);
    newElement.innerHTML = '<h3>Construction # ' + (counter) + '</h3><br>'  ;
    newElement.innerHTML += 'Dimensions in mm: <input type=\"text\" name=\"length[]\" size=10 /> x <input type=\"text\" name=\"width[]\" size=10 /> ';
    newElement.innerHTML += 'U-value: <input type=\"text\" name=\"uvalues[]\" size=4 />';
    newElement.innerHTML += '<button onclick=\"addWindow(\'Element'+counter+'\')\" type=\"button\">add window or door </button>';
    newElement.innerHTML += '<button onclick=\"removeSurface(\'Element'+counter+'\')\" type=\"button\">remove </button>';
    form.appendChild(newElement);
    counter++;
}

/**
 * remove surface from form
 */
function removeSurface(id) {

    var form = document.getElementById("unitFormID");
    form.removeChild(document.getElementById(id));
}

function addWindow(id) {
    var surface = document.getElementById(id);
    var newElement = document.createElement('div');
    newElement.setAttribute('class','windowForm')
    newElement.setAttribute('id', 'Element'+windowCounter);
    newElement.innerHTML = '<h3>Element of construction # ' + (windowCounter) + '</h3><br>'  ;
    newElement.innerHTML += 'Dimensions in mm: <input type=\"text\" name=\"length[]\" size=10 /> x <input type=\"text\" name=\"width[]\" size=10 /> ';
    newElement.innerHTML += 'U-value: <input type=\"text\" name=\"uvalues[]\" size=4 />';
    newElement.innerHTML += '<button onclick=\"removeSurface(\'Element'+windowCounter+'\')\" type=\"button\">remove </button>';
    surface.appendChild(newElement);
    windowCounter++;
}