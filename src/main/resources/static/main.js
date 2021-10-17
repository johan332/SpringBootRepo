$('document').ready(function()
{
    $('.table .btn-warning').on('click', function(event)
    {
        event.preventDefault();

       var href=$(this).attr('href');

       $.get(href, function(employee, status)
       {
            $('#IdEdit').val(employee.id);
            $('#nameEdit').val(employee.name);
            $('#departmentEdit').val(employee.department);
            $('#updatedByEdit').val(employee.updatedBy);
            $('#updatedOnEdit').val(employee.updatedOn.substr(0,10));
       });

        $('#editModal').modal();
    });

    $('.table #deleteButton').on('click',function(event)
    {
    		event.preventDefault();
            	var href = $(this).attr('href');
            	$('#deleteModal #deleteId').attr('href', href);
            	$('#deleteModal').modal();

    	});
});