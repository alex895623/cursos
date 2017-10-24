jQuery(document).ready(function() {
  $('[data-toggle="tooltip"]').tooltip();
});

$('[data-provide=datepicker]').datepicker({
    format: 'dd/mm/yyyy',
    autoclose: true
  });
