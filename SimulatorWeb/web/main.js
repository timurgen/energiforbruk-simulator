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
/**
 * Sjekker at brukernavn eller epost er allerede registrert
 * Sjekker at password stememr i begge feltene
 * Sjekker at emeil har valid format og stemmer i begge feltene
 */
function checkRegInfo() {
    var name = document.getElementById('id_name').value;//funker
    var email1 = document.getElementById('id_mail1').value;//funker
    var email2 = document.getElementById('id_mail2').value;//funker
    var pass1 = document.getElementById('id_pass1').value;//funker
    var pass2 = document.getElementById('id_pass2').value;//funker
    //sjekker om brukernavn har lengde fra 3 til 18
    if(name.length < 3 | name.length > 18) { 
        document.getElementById('id_lbl_name').style.color = 'red';
        document.getElementById('register_form_wrong_message').innerHTML = "name must have length more than 3 and less than 18!";//funker
        return false;
    }
    //sjekker om epost feiler
    if(email1 != email2) {
        document.getElementById('register_form_wrong_message').innerHTML = "Check emails!";//funker
        document.getElementById('id_lbl_mail').style.color = 'red';
        document.getElementById('id_lbl_mail2').style.color = 'red';
        return false;
    }
    //sjekker om password feiler
    if(pass1 != pass2) {
        document.getElementById('register_form_wrong_message').innerHTML = "Check passwords!";//funker
        document.getElementById('id_lbl_pass').style.color = 'red';
        document.getElementById('id_lbl_pass2').style.color = 'red';
        return false;
    }
    //sjekker om email har valid format
    var regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    if(email1.match(regex) == null) {
        document.getElementById('register_form_wrong_message').innerHTML = "Email invalid";
        return false;
    } 
    
    
    //sjekker om brukernavn eller epost er registrert allerede
    var output = ajaxCheck(name,email1);
    if(output == "true") {
        document.getElementById('register_form_wrong_message').innerHTML = "username or email exists";//funker
        return false;
    }
    return true;
    

    
}


/**
 * Ajax function sjekker om brukernavn eller epost er registrert allerede
 */
function ajaxCheck(name, email) {
    var query = "?mode=check&name="+name+"&email="+email;
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// moderne nettlesere
        xmlhttp=new XMLHttpRequest();      
    }
    else
    {// gammelt ie
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    //sender request
    xmlhttp.open("GET","user"+query,false);
    xmlhttp.send(null);
    return xmlhttp.responseText;
}