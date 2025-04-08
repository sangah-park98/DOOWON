/*[list] 초기 데이터 get*/
var notPdfDate ="";
/*[list] 초기 데이터 get*/
$( document ).ready(function() {
	setTimeout(exportPdf, 500);
});


/*개월수 계산*/
function getPdfMonthDiff(date1, date2) {
    let year1 = Number(date1.slice(0, 4));
    let month1 = Number(date1.slice(5, 7));
    let year2 = Number(date2.slice(0, 4));
    let month2 = Number(date2.slice(5, 7));
    return (year2 - year1) * 12 + (month2 - month1) + 2;
}

function exportPdf(){

	if (!window.jsPDF) window.jsPDF = window.jspdf.jsPDF;
	var doc = new jsPDF("l", "mm", "b4");

    doc.addFileToVFS("NotoSans-Regular.ttf", fonts);
	doc.addFont("NotoSans-Regular.ttf", "NotoSans-Regular", "normal");
	doc.setFont("NotoSans-Regular");

    var isCheck = false;
    

    // 일반현황 출력
    if ($('#tb_first_common_area').css('display') === 'inline-block') {
    	

		// 일반현황 표지
	    if ($("#tb_first_common").length > 0) {
	        isCheck = true;
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo.png'
	        doc.addImage(img, 'png', 320, 10, 25, 10)
	
	        doc.setFillColor(56, 60, 98);
	        doc.rect(0, 50, 500, 100, 'FD');
	
	        var img = new Image()
	        img.src = '/pf/images/pdf_01.png'
	        doc.addImage(img, 'png', 0, 50, 100, 100)
	

	
	        doc.setFontSize(30);
	        doc.setTextColor(255, 255, 255);
	        doc.text(120, 110, $('#tb_first_common .cover_center tr:eq(0)>td:eq(1)>div:eq(0)').text());
	
	        
	
	        doc.setFontSize(15);
	        doc.setTextColor(56, 60, 98);
	        doc.text(230, 220, $('#tb_first_common .cover_footer div:eq(0)').text());
	
	        doc.setFontSize(15);
	        doc.setTextColor(56, 60, 98);
	        doc.text(230, 230, $('#tb_first_common .cover_footer div:eq(1)').text());
	        
	        doc.setFontSize(15);
	        doc.setTextColor(56, 60, 98);
	        doc.text(230, 240, $('#tb_first_common .cover_footer div:eq(2)').text());
	        
	        
	       

	    }
	    // 수입실적
	    if ($('#tb_import_area').css('display') === 'inline-block' && $("#tb_import_body").length > 0) {
	        doc.addPage('l', 'mm');
	
	        doc.setFillColor(56, 60, 98);
	        doc.rect(0, 0, 500, 30, 'FD');
	
	        doc.setFontSize(20);
	        doc.setTextColor(255, 255, 255);
	        doc.text(20, 15, $('#tb_import_head tr:eq(0)>td:eq(0)>h1:eq(0)').text());
	
	
	        doc.setFontSize(15);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 25, $('#tb_import_head tr:eq(0)>td:eq(0)>div:eq(0)').text());
	
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo_w.png'
	        doc.addImage(img, 'png', 320, 10, 25, 10)
	
	        doc.autoTable(
				{ html: '#tb_import_body',
					 styles: {
					    font: "NotoSans-Regular",
					    fontStyle: "normal",
					   /* overflow: 'linebreak',*/
					    cellWidth: 'wrap',
					    lineColor: [240, 240, 240],
					    lineWidth: 0.2
						  },
				  useCss: true,
				  startX: 10,
				  startY: 45,
				  includeHiddenHtml: false,
				  rowPageBreak: 'avoid',
				  headStyles: { halign: "center", valign: "middle" },
				  columnStyles: {
				    0: { cellWidth: 5 },
				    1: { cellWidth: 20 },
				    2: { cellWidth: 25 },
				    3: { cellWidth: 30 },
				    4: { cellWidth: 30 },
				    5: { cellWidth: 25 },
				    6: { cellWidth: 50 },
				    7: { cellWidth: 25 },
				    8: { cellWidth: 30 },
				    9: { cellWidth: 45 },
				    10: { cellWidth: 40 }
					}
				}
			);
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(155, doc.autoTable.previous.finalY + 10, $('#moreMsg').text());

	        
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(150, doc.autoTable.previous.finalY + 15, $('#moreMsg2').text());
	    }
	    // 수출실적
	    if ($('#tb_export_area').css('display') === 'inline-block' && $("#tb_export_body").length > 0) {
	        doc.addPage('l', 'mm');
	
	        doc.setFillColor(56, 60, 98);
	        doc.rect(0, 0, 500, 30, 'FD');
	        
	        doc.setFontSize(20);
	        doc.setTextColor(255, 255, 255);
	        doc.text(20, 15, $('#tb_export_head tr:eq(0)>td:eq(0)>h1:eq(0)').text());
	
	        doc.setFontSize(15);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 25, $('#tb_export_head tr:eq(0)>td:eq(0)>div:eq(0)').text());
	
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo_w.png'
	        doc.addImage(img, 'png',320, 10, 25, 10)
	        
	        doc.autoTable(
				{ html: '#tb_export_body',
				  styles: { font: "NotoSans-Regular", fontStyle: "normal", overflow: 'linebreak', cellWidth: 'wrap', lineColor: [240, 240, 240], lineWidth: 0.2 },
				  useCss: true,
				  startX: 10,
				  startY: 45,
				  includeHiddenHtml: true,
				  rowPageBreak: 'avoid',
				  headStyles: { halign: "center", valign: "middle" },
				  columnStyles: {
				    0: { cellWidth: 5 },
				    1: { cellWidth: 20 },
				    2: { cellWidth: 25 },
				    3: { cellWidth: 25 },
				    4: { cellWidth: 20 },
				    5: { cellWidth: 20 },
				    6: { cellWidth: 20 },
				    7: { cellWidth: 20 },
				    8: { cellWidth: 15 },
				    9: { cellWidth: 15 },
				    10: { cellWidth: 20 },
				    11: { cellWidth: 15 },
				    12: { cellWidth: 20 },
				    13: { cellWidth: 20 },
				    14: { cellWidth: 20 },
				    15: { cellWidth: 10 },
				    16: { cellWidth: 25 },
				    17: { cellWidth: 15 }
					}
				}
			);
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(155, doc.autoTable.previous.finalY + 10, $('#moreMsg3').text());

	        
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(150, doc.autoTable.previous.finalY + 15, $('#moreMsg4').text());
	    }
	    // 월간수출입통관현황(1)
	    if ($('#tb_export_area2').css('display') === 'inline-block' && $("#tb_export_body2").length > 0) {
	        doc.addPage('l', 'mm');
	
	        doc.setFillColor(56, 60, 98);
	        doc.rect(0, 0, 500, 30, 'FD');
	        
	        doc.setFontSize(20);
	        doc.setTextColor(255, 255, 255);
	        doc.text(20, 15, $('#tb_export_head2 tr:eq(0)>td:eq(0)>h1:eq(0)').text());
	
	        doc.setFontSize(15);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 25, $('#tb_export_head2 tr:eq(0)>td:eq(0)>div:eq(0)').text());
	
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo_w.png'
	        doc.addImage(img, 'png', 320, 10, 25, 10)
	        
	        doc.autoTable(
				{ html: '#tb_export_body2',
				  styles: { font: "NotoSans-Regular", fontStyle: "normal", overflow: 'linebreak', cellWidth: 'wrap', lineColor: [240, 240, 240], lineWidth: 0.2 },
				  useCss: true,
				  startX: 10,
				  startY: 45,
				  includeHiddenHtml: true,
				  rowPageBreak: 'avoid',
				  headStyles: { halign: "center", valign: "middle" },
				  columnStyles: {
				    0: { cellWidth: 5 },
				    1: { cellWidth: 20 },
				    2: { cellWidth: 30 },
				    3: { cellWidth: 30 },
				    4: { cellWidth: 60 },
				    5: { cellWidth: 30 },
				    6: { cellWidth: 30 },
				    7: { cellWidth: 30 },
				    8: { cellWidth: 30 },
				    9: { cellWidth: 30 },
				    10: { cellWidth: 30 }
					}
				}
			);
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(155, doc.autoTable.previous.finalY + 10, $('#moreMsg5').text());

	        
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(150, doc.autoTable.previous.finalY + 15, $('#moreMsg6').text());
	    }
	    
    }
    const addFooters = (doc) => {
        // 페이지 전체 높이
        const PAGE_HEIGHT = doc.internal.pageSize.height || doc.internal.pageSize.getHeight();
        // 페이지 전체 너비
        const PAGE_WIDTH = doc.internal.pageSize.width || doc.internal.pageSize.getWidth();
    		
        const pageCount = doc.internal.getNumberOfPages();

        doc.setFont('NotoSans-Regular', 'normal');
        doc.setFontSize(10);
        doc.setTextColor(56, 60, 98);
    		
        for (var i = 1; i < pageCount; i++) {
            doc.setPage(i+1);
            doc.text(`- ${i} / ${pageCount-1} -`, PAGE_WIDTH / 2, PAGE_HEIGHT - 10, {
                align: 'center'
            });
        }
    };
    
    addFooters(doc);
    
    doc.save("report1.pdf");

}