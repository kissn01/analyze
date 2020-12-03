$(document).ready(function() {

    $('.configurator input, .configurator select').change(function() {
        updateConfig();
    });

    /*点击图标弹出日历选择*/
    $('.demo i').click(function() {
        $(this).parent().find('input').click();
    });

    $('#startDate').daterangepicker({
        singleDatePicker: true,
        startDate: moment().subtract(6, 'days')
    });

    $('#endDate').daterangepicker({
        singleDatePicker: true,
        startDate: moment()
    });

    updateConfig();

    function updateConfig() {
        var options = {};

        if(1 == 1) {
            $('#rtl-wrap').show();
            options.locale = {
                format: 'YYYY-MM-DD',
                separator: ' - ',
                applyLabel: '确定',
                cancelLabel: '取消',
                fromLabel: 'From',
                toLabel: 'To',
                customRangeLabel: 'Custom',
                daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
                monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
                firstDay: 1
            };
        }

        $('#config-demo').daterangepicker(options, function(start, end, label) {
            console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')');
        });

    }

});