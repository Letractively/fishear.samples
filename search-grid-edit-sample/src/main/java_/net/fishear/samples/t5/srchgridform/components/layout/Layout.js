
function showLogin() {
	$jq("#loginFormDialog").dialog("open");
}

//var pmInstance;
$jq(function() {
	// I dedicated it to independent class to allow call this method (eventually) from zone update...
	//pmInstance = new ProfileMenu();
	$jq("#loginFormDialog").dialog({ minWidth: 550, width: 550, modal: true, autoOpen: false, open: function(event, ui) { $jq("#username").focus(); } });

});
