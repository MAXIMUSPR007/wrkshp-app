$(document).ready(function() {
	bindSearch();
	bindDateTimePicker();
});

function bindSearch() {
	$('#criteria').on("keypress", function (e) {
		var key = e.which;
		// the enter key code
		if(key == 13) {
			$('#btnSearch').click();
			return false;  
		}
	});
}

function bindDateTimePicker() {
	$('#startDateTimePicker').datetimepicker({
		defaultDate: $("#start").val(),
		format: "YYYY-MM-DD"
	});
	$('#endDateTimePicker').datetimepicker({
		defaultDate: $("#end").val(),
		format: "YYYY-MM-DD"
	});
}