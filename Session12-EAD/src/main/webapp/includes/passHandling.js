let dollarPerRuppee = 0.014;
let yenPerRuppee = 1.54;
let cyclePassPrice = [ 5, 100, 500 ];
let motorCyclePassPrice = [ 10, 200, 1000 ];
let fourWheelersPassPrice = [ 20, 500, 3500 ];

function convertCurrency(passPrice) {
	currencyTypeElement = document.getElementById("currencyType");
	currencyType = currencyTypeElement.options[currencyTypeElement.selectedIndex].value;
	if (currencyType == "USD") {
		document.getElementById("showPassPrice").innerHTML = passPrice
		* dollarPerRuppee;
	} else if (currencyType == "YEN") {
		document.getElementById("showPassPrice").innerHTML = passPrice
		* yenPerRuppee;
	} else {
		document.getElementById("showPassPrice").innerHTML = passPrice;
	}
}

function updatePassPrice(vehicleType) {
	document.getElementById("pass-div").style.visibility = "visible";
	passTypeElement = document.getElementById("passType");
	passType = passTypeElement.options[passTypeElement.selectedIndex].value;
	if (vehicleType == "cycle") {
		if (passType == "daily") {
			document.getElementById("passValue").value = cyclePassPrice[0] * dollarPerRuppee;
			convertCurrency(cyclePassPrice[0]);
		} else if (passType == "monthly") {
			document.getElementById("passValue").value = cyclePassPrice[1] * dollarPerRuppee;
			convertCurrency(cyclePassPrice[1]);
		} else {
			document.getElementById("passValue").value = cyclePassPrice[2] * dollarPerRuppee;
			convertCurrency(cyclePassPrice[2]);
		}
	} else if (vehicleType == "motorcycle") {
		if (passType == "daily") {
			document.getElementById("passValue").value = motorCyclePassPrice[0] * dollarPerRuppee;
			convertCurrency(motorCyclePassPrice[0]);
		} else if (passType == "monthly") {
			document.getElementById("passValue").value = motorCyclePassPrice[1] * dollarPerRuppee;
			convertCurrency(motorCyclePassPrice[1]);
		} else {
			document.getElementById("passValue").value = motorCyclePassPrice[2] * dollarPerRuppee;
			convertCurrency(motorCyclePassPrice[2]);
		}
	} else {
		if (passType == "daily") {
			document.getElementById("passValue").value = fourWheelersPassPrice[0] * dollarPerRuppee;
			convertCurrency(fourWheelersPassPrice[0]);
		} else if (passType == "monthly") {
			document.getElementById("passValue").value = fourWheelersPassPrice[1] * dollarPerRuppee;
			convertCurrency(fourWheelersPassPrice[1]);
		} else {
			document.getElementById("passValue").value = fourWheelersPassPrice[2] * dollarPerRuppee;
			convertCurrency(fourWheelersPassPrice[2]);
		}
	}

}