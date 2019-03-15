! function(t) {
    "use strict";
    try {
        t(".js-datepicker").daterangepicker({
            singleDatePicker: !0,
            showDropdowns: !0,
            autoUpdateInput: !1,
            minDate:"01/01/1997",

            locale: {
                format: "DD/MM/YYYY"
            }
        });
        var o = t(".js-datepicker"),
            n = 0;
        t(window).on("click", function() {
            n = 0
        }), t(o).on("apply.daterangepicker", function(o, c) {
            n = 0, t(this).val(c.startDate.format("DD/MM/YYYY"))
        }), t(".js-btn-calendar").on("click", function(t) {
            t.stopPropagation(), 1 === n ? n = 0 : 0 === n && (n = 1), 1 === n && o.focus()
        }), t(o).on("click", function(t) {
            t.stopPropagation(), n = 1
        }), t(".daterangepicker").on("click", function(t) {
            t.stopPropagation()
        })
    } catch (t) {
        console.log(t)
    }
    try {
        t(".js-select-simple").each(function() {
            var o = t(this),
                n = o.find("select"),
                c = o.find(".select-dropdown");
            n.select2({
                dropdownParent: c
            })
        })
    } catch (t) {
        console.log(t)
    }
}(jQuery);
$('.print-icon').on('click', function() {
    window.print();
    return false; // why false?
});