function bootUp(){
	$.get('/app/org/get',function(data){
		window.stuff = JSON.parse(data);
		$('#organizationName').text(window.stuff.name);
	});
}