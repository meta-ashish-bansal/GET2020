var empID = 0;
var fullName;
var vehicleType;
var dollarPerRuppee = 0.014;
var yenPerRuppee = 1.54;
var cyclePassPrice = [5, 100, 500];
var motorCyclePassPrice = [10, 200, 1000];
var fourWheelersPassPrice = [20, 500, 3500];
var passType;
function display(formId) {
    if ("block" == document.getElementById(formId).style.display) {
        return document.getElementById(formId).style.display = "none";
    }
    else {
        return document.getElementById(formId).style.display = "block";
    }
}
function validateName() {
    fullName = document.getElementById('fullName').value;
    var namePattern = new RegExp(/^[A-Za-z\s]+$/i);
    if ((namePattern.test(fullName)) && fullName.length >= 2) {
        document.getElementById("divFullName").style.display = "none";
        document.getElementById("divGender").style.display = "block";
        document.getElementById('genderLabel').innerHTML = "Hi " + fullName + "! Can i know your gender";
    }
    else {
        alert("Fill name properly");
    }
}
function validateGender() {
    if ((document.getElementById('male').checked) || (document.getElementById('female').checked)) {
        document.getElementById("divGender").style.display = "none";
        document.getElementById("divEmail").style.display = "block";
        document.getElementById('emailLabel').innerHTML = "Hi " + fullName + "! Can i know your email Id";
    }
    else {
        alert("Please Choose Gender");
    }
}
function validateEmail() {
    var email = document.getElementById('email').value;
    var namePattern = new RegExp(/^[A-Za-z0-9\.]+@[A-Za-z]+.com+$/i);
    if (namePattern.test(email)) {
        document.getElementById("divEmail").style.display = "none";
        document.getElementById("divPassword").style.display = "block";
        document.getElementById('passwordLabel').innerHTML = "Hi " + fullName + "! please enter password";
    }
    else {
        alert("Fill email Properly");
    }
}
function checkPassword() {
    document.getElementById("passwordButton").disabled = true;
    var lowerCaseLetters = new RegExp(/[a-z]/g);
    var upperCaseLetters = new RegExp(/[A-Z]/g);
    var numbers = new RegExp(/[0-9]/g);
    var counter = 0;
    var password = document.getElementById('password').value;
    if (lowerCaseLetters.test(password)) {
        counter = counter + 1;
    }
    if (upperCaseLetters.test(password)) {
        counter = counter + 1;
    }
    if (numbers.test(password)) {
        counter = counter + 1;
    }
    if (password.length > 8) {
        counter = counter + 1;
    }
    if (counter < 2) {
        document.getElementById("password").style.borderColor = "red";
    }
    else if (counter == 2 || counter == 3) {
        document.getElementById("password").style.borderColor = "orange";
    }
    else {
        document.getElementById("password").style.borderColor = "green";
        document.getElementById("passwordButton").disabled = false;
    }
}
function validatePassword() {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    if (((password == confirmPassword) && (password != ""))) {
        document.getElementById("divPassword").style.display = "none";
        document.getElementById("divContactNumber").style.display = "block";
        document.getElementById('contactNumberLabel').innerHTML = "Hi " + fullName + "! Can i know your contact number";
    }
    else {
        alert("Confirm Password did not match");
    }
}
function validateContactNumber() {
    var contactNumber = document.getElementById('contactNumber').value;
    var numberPattern = new RegExp(/^\d{10}$/);
    if (numberPattern.test(contactNumber)) {
        document.getElementById("divContactNumber").style.display = "none";
        document.getElementById("empId").innerHTML = (String)(++empID);
        document.getElementById('vehicleNameLabel').innerHTML = "Hi " + fullName + "! Can i know your Vehicle Name";
        display('addEmployee');
        display('addVehicle');
        document.getElementById("divVehicleName").style.display = "block";
    }
    else {
        alert("Fill Contact number Properly");
    }
}
function validateVehicleName() {
    var vehicleName = document.getElementById('vehicleName').value;
    var namePattern = new RegExp(/^[A-Za-z0-9]+$/i);
    if (namePattern.test(vehicleName)) {
        document.getElementById("divVehicleName").style.display = "none";
        document.getElementById("divVehicleType").style.display = "block";
        document.getElementById('vehicleTypeLabel').innerHTML = "Hi " + fullName + "! Which vehicle do you have";
    }
    else {
        alert('Fill Vehicle Name Properly');
    }
}
function validateVehicleType() {
    if ((document.getElementById('cycle').checked || document.getElementById('motorCycle').checked || document.getElementById('fourWheeler').checked)) {
        var vehicleTypes = document.getElementsByName('vehicleType');
        for (var i = 0; i < vehicleTypes.length; i++) {
            if (vehicleTypes[i].checked) {
                vehicleType = vehicleTypes[i].value;
                break;
            }
        }
        document.getElementById("divVehicleType").style.display = "none";
        document.getElementById("divVehicleNumber").style.display = "block";
        document.getElementById('vehicleNumberLabel').innerHTML = "Hi " + fullName + "! Can i know your Vehicle Number";
    }
    else {
        alert('Fill Vehicle type Properly');
    }
}
function validateVehicleNumber() {
    var vehicleNumber = document.getElementById('vehicleNumber').value;
    var numberPattern = new RegExp(/^[A-za-a0-9]+$/i);
    if (numberPattern.test(vehicleNumber)) {
        document.getElementById("divVehicleNumber").style.display = "none";
        document.getElementById("divVehicleIdentification").style.display = "block";
        document.getElementById('vehicleTypeLabel').innerHTML = "Hi " + fullName + "! Can i know your Vehicle Identification";
    }
    else {
        alert('Fill Vehicle Name Properly');
    }
}
function convertCurrency(passPrice, passType) {
    var currencyTypeElement = document.getElementById("currencyType");
    var currencyType = currencyTypeElement.options[currencyTypeElement.selectedIndex].value;
    if (currencyType == "USD") {
        document.getElementById("passValue").innerHTML = passPrice
            * dollarPerRuppee + "  /" + passType;
    }
    else if (currencyType == "YEN") {
        document.getElementById("passValue").innerHTML = passPrice
            * yenPerRuppee + "  /" + passType;
    }
    else {
        document.getElementById("passValue").innerHTML = passPrice + " /" + passType;
    }
}
function updatePassPrice() {
    var passTypeElement = document.getElementById("passType");
    passType = passTypeElement.options[passTypeElement.selectedIndex].value;
    if (vehicleType == "Cycle") {
        if (passType == "Daily") {
            document.getElementById("passValue").value = (String)(cyclePassPrice[0] * dollarPerRuppee);
            convertCurrency(cyclePassPrice[0], passType);
        }
        else if (passType == "Monthly") {
            document.getElementById("passValue").value = (String)(cyclePassPrice[1] * dollarPerRuppee);
            convertCurrency(cyclePassPrice[1], passType);
        }
        else {
            document.getElementById("passValue").value = (String)(cyclePassPrice[2] * dollarPerRuppee);
            convertCurrency(cyclePassPrice[2], passType);
        }
    }
    else if (vehicleType == "Motor Cycle") {
        if (passType == "Daily") {
            document.getElementById("passValue").value = (String)(motorCyclePassPrice[0] * dollarPerRuppee);
            convertCurrency(motorCyclePassPrice[0], passType);
        }
        else if (passType == "Monthly") {
            document.getElementById("passValue").value = (String)(motorCyclePassPrice[1] * dollarPerRuppee);
            convertCurrency(motorCyclePassPrice[1], passType);
        }
        else {
            document.getElementById("passValue").value = (String)(motorCyclePassPrice[2] * dollarPerRuppee);
            convertCurrency(motorCyclePassPrice[2], passType);
        }
    }
    else {
        if (passType == "Daily") {
            document.getElementById("passValue").value = (String)(fourWheelersPassPrice[0] * dollarPerRuppee);
            convertCurrency(fourWheelersPassPrice[0], passType);
        }
        else if (passType == "Monthly") {
            document.getElementById("passValue").value = (String)(fourWheelersPassPrice[1] * dollarPerRuppee);
            convertCurrency(fourWheelersPassPrice[1], passType);
        }
        else {
            document.getElementById("passValue").value = (String)(fourWheelersPassPrice[2] * dollarPerRuppee);
            convertCurrency(fourWheelersPassPrice[2], passType);
        }
    }
}
function validateVehicleIdentifictaion() {
    var vehicleIdentification = document.getElementById('vehicleIdentification').value;
    var pattern = new RegExp(/^[A-Za-z0-9\s]+$/i);
    if (pattern.test(vehicleIdentification)) {
        document.getElementById("divVehicleIdentification").style.display = "none";
        document.getElementById("divVehicleIdentification").style.display = "block";
        document.getElementById('pricingLabel').innerHTML = "Hi " + fullName + "! Please Select " + vehicleType + " pass";
        display('addVehicle');
        display('pricing');
        document.getElementById("pass").style.display = "block";
        document.getElementById("showVehicleType").innerHTML = vehicleType;
        if (vehicleType == "Cycle") {
            document.getElementById("passValue").innerHTML = "$100 /month";
        }
        else if (vehicleType == "Motor Cycle") {
            document.getElementById("passValue").innerHTML = "$200 /month";
        }
        else if (vehicleType == "Four Wheeler") {
            document.getElementById("passValue").innerHTML = "$500 /month";
        }
    }
    else {
        alert('Fill Vehicle Identification Properly');
    }
}
function finalPassPrice() {
    var passValue = document.getElementById("passValue").value;
    document.getElementById("showfinalVehicleType").innerHTML = vehicleType;
    document.getElementById("showfinalPassType").innerHTML = "Pass Type: " + passType;
    document.getElementById("showfinalPassValue").innerHTML = "Pass Value: " + passValue;
    document.getElementById("pass").style.display = "none";
    document.getElementById("finalPass").style.display = "block";
}
