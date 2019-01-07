
function createTime(v){
    var date = new Date(v);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var M = date.getMinutes();
    M = M<10?("0"+M):M;
    var str = y+"-"+m+"-"+d+" "+h+":"+M;
    return str;
}

function merge(res) {

    var data = res.data;
    var columsName = ['SELECT_A','SELECT_B','SELECT_C','SELECT_D'];//需要合并的列名称

    var trArr = $(".layui-table-body>.layui-table").find("tr");//所有行
    for (var i = 1; i < res.data.length; i++) { //这里循环表格当前的数据
        var mark = 1; //这里涉及到简单的运算，mark是计算每次需要合并的格子数
        var tdCurArr = trArr.eq(i).find("td").eq(columsIndex[0]);//获取当前行的当前列
        for (var k = 1; k < columsName.length; k++) { //这里循环所有要合并的列
            if (data[i][columsName[k]] === "") { //后一行的值与前一行的值做比较，相同就需要合并
                mark += 1;
                tdCurArr.each(function () {//当前行隐藏
                    $(this).css("colspan", mark);
                });
                var tdPreArr = trArr.eq(i).find("td").eq(columsIndex[k]);//获取当前行的当前列
                tdPreArr.each(function () {//相同列的第一列增加rowspan属性
                    $(this).attr("display", "none");
                });
            }else {
                mergeIndex = i;
                mark = 1;//一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
            }
        }
    }
}
