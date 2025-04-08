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
	        doc.rect(0, 0, 500, 35, 'FD');
	
	        doc.setFontSize(20);
	        doc.setTextColor(255, 255, 255);
	        doc.text(20, 15, $('#tb_import_head tr:eq(0)>td:eq(0)>h1:eq(0)').text());
	
	
	        doc.setFontSize(13);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 25, $('#tb_import_head tr:eq(0)>td:eq(0)>div:eq(0)').text());
	        
	        doc.setFontSize(13);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 30, $('#tb_import_head tr:eq(0)>td:eq(0)>div:eq(1)').text());
	        
	       
	        
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo_w.png'
	        doc.addImage(img, 'png', 320, 10, 25, 10)
	
	        doc.autoTable(
				{ html: '#tb_import_body',
				  styles: { font: "NotoSans-Regular", fontStyle: "normal", overflow: 'linebreak', cellWidth: 'wrap', lineColor: [240, 240, 240], lineWidth: 0.2 },
				  useCss: true,
				  startX: 10,
				  startY: 45,
				  includeHiddenHtml: false,
				  rowPageBreak: 'avoid',
				  headStyles: { halign: "center", valign: "middle" },
				  columnStyles: {
				    0: { cellWidth: 5 },
				    1: { cellWidth: 30 },
				    2: { cellWidth: 80 },
				    3: { cellWidth: 110 },
				    4: { cellWidth: 50 },
				    5: { cellWidth: 50 }
					}
				}
			);
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(155, doc.autoTable.previous.finalY + 10, $('#moreMsg31').text());

	        
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(150, doc.autoTable.previous.finalY + 15, $('#moreMsg32').text());
	    }
	    if ($('#tb_import_area2').css('display') === 'inline-block' && $("#tb_import_body2").length > 0) {
	        doc.addPage('l', 'mm');
	
	        doc.setFillColor(56, 60, 98);
	        doc.rect(0, 0, 500, 30, 'FD');
	
	        doc.setFontSize(20);
	        doc.setTextColor(255, 255, 255);
	        doc.text(20, 15, $('#tb_import_head2 tr:eq(0)>td:eq(0)>h1:eq(0)').text());
	
	
	        doc.setFontSize(15);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 25, $('#tb_import_head2 tr:eq(0)>td:eq(0)>div:eq(0)').text());
	
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo_w.png'
	        doc.addImage(img, 'png', 320, 10, 25, 10)
	
	        doc.autoTable(
				{ html: '#tb_import_body2',
				  styles: { font: "NotoSans-Regular", fontStyle: "normal", overflow: 'linebreak', cellWidth: 'wrap', lineColor: [240, 240, 240], lineWidth: 0.2 },
				  useCss: true,
				  startX: 10,
				  startY: 45,
				  includeHiddenHtml: false,
				  rowPageBreak: 'avoid',
				  headStyles: { halign: "center", valign: "middle" },
				  columnStyles: {
				    0: { cellWidth: 5 },
				    1: { cellWidth: 20 },
				    2: { cellWidth: 30 },
				    3: { cellWidth: 30 },
				    4: { cellWidth: 25 },
				    5: { cellWidth: 40 },
				    6: { cellWidth: 50 },
				    7: { cellWidth: 25 },
				    8: { cellWidth: 40 },
				    9: { cellWidth: 50 }
					}
				}
			);
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(155, doc.autoTable.previous.finalY + 10, $('#moreMsg33').text());

	        
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(150, doc.autoTable.previous.finalY + 15, $('#moreMsg34').text());
	    }
	    if ($('#tb_import_area3').css('display') === 'inline-block' && $("#tb_import_body3").length > 0) {
	        doc.addPage('l', 'mm');
	
	        doc.setFillColor(56, 60, 98);
	        doc.rect(0, 0, 500, 30, 'FD');
	
	        doc.setFontSize(20);
	        doc.setTextColor(255, 255, 255);
	        doc.text(20, 15, $('#tb_import_head3 tr:eq(0)>td:eq(0)>h1:eq(0)').text());
	
	if(lang == 'kr'){
	        doc.setFontSize(15);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 25, rvcRatio+'% '+ checkrpt3 );
	
	}else {
	    doc.setFontSize(15);
        doc.setTextColor(255, 255, 102);
        doc.text(20, 25, checkrpt3+rvcRatio+'%');
    
	}
	       
	
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo_w.png'
	        doc.addImage(img, 'png',320, 10, 25, 10)
	
	        doc.autoTable(
				{ html: '#tb_import_body3',
				  styles: { font: "NotoSans-Regular", fontStyle: "normal", overflow: 'linebreak', cellWidth: 'wrap', lineColor: [240, 240, 240], lineWidth: 0.2 },
				  useCss: true,
				  startX: 10,
				  startY: 45,
				  includeHiddenHtml: false,
				  rowPageBreak: 'avoid',
				  headStyles: { halign: "center", valign: "middle" },
				  columnStyles: {
				    0: { cellWidth: 5 },
				    1: { cellWidth: 20 },
				    2: { cellWidth: 30 },
				    3: { cellWidth: 60 },
				    4: { cellWidth: 30 },
				    5: { cellWidth: 35 },
				    6: { cellWidth: 25 },
				    7: { cellWidth: 40 },
				    8: { cellWidth: 40 },
				    9: { cellWidth: 35 }
					}
				}
			);
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(155, doc.autoTable.previous.finalY + 10, $('#moreMsg35').text());

	        
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(145, doc.autoTable.previous.finalY + 15, $('#moreMsg36').text());
	    }
	    if ($('#tb_import_area4').css('display') === 'inline-block' && $("#tb_import_body4").length > 0) {
	        doc.addPage('l', 'mm');
	
	        doc.setFillColor(56, 60, 98);
	        doc.rect(0, 0, 500, 30, 'FD');
	
	        doc.setFontSize(20);
	        doc.setTextColor(255, 255, 255);
	        doc.text(20, 15, $('#tb_import_head4 tr:eq(0)>td:eq(0)>h1:eq(0)').text());
	
	
	        doc.setFontSize(13);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 25, $('#tb_import_head4 tr:eq(0)>td:eq(0)>div:eq(0)').text());
	
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo_w.png'
	        doc.addImage(img, 'png',320, 10, 25, 10)
	
	        doc.autoTable(
				{ html: '#tb_import_body4',
				  styles: { font: "NotoSans-Regular", fontStyle: "normal", overflow: 'linebreak', cellWidth: 'wrap', lineColor: [240, 240, 240], lineWidth: 0.2 },
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
				    3: { cellWidth: 50 },
				    4: { cellWidth: 30 },
				    5: { cellWidth: 35 },
				    6: { cellWidth: 30 },
				    7: { cellWidth: 45 },
				    8: { cellWidth: 40 },
				    9: { cellWidth: 40 }
					}
				}
			);
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(155, doc.autoTable.previous.finalY + 10, $('#moreMsg37').text());

	        
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(150, doc.autoTable.previous.finalY + 15, $('#moreMsg38').text());
	    }
	    if ($('#tb_import_area5').css('display') === 'inline-block' && $("#tb_import_body5").length > 0) {
	        doc.addPage('l', 'mm');
	
	        doc.setFillColor(56, 60, 98);
	        doc.rect(0, 0, 500, 30, 'FD');
	
	        doc.setFontSize(20);
	        doc.setTextColor(255, 255, 255);
	        doc.text(20, 15, $('#tb_import_head5 tr:eq(0)>td:eq(0)>h1:eq(0)').text());
	
	
	        doc.setFontSize(13);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 25, $('#tb_import_head5 tr:eq(0)>td:eq(0)>div:eq(0)').text());
	
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo_w.png'
	        doc.addImage(img, 'png', 320, 10, 25, 10)
	
	        doc.autoTable(
				{ html: '#tb_import_body5',
				  styles: { font: "NotoSans-Regular", fontStyle: "normal", overflow: 'linebreak', cellWidth: 'wrap', lineColor: [240, 240, 240], lineWidth: 0.2 },
				  useCss: true,
				  startX: 10,
				  startY: 45,
				  includeHiddenHtml: false,
				  rowPageBreak: 'avoid',
				  headStyles: { halign: "center", valign: "middle" },
				  columnStyles: {
				    0: { cellWidth: 5 },
				    1: { cellWidth: 20 },
				    2: { cellWidth: 30 },
				    3: { cellWidth: 60 },
				    4: { cellWidth: 35 },
				    5: { cellWidth: 40 },
				    6: { cellWidth: 50 },
				    7: { cellWidth: 40 },
				    8: { cellWidth: 40 }
					}
				}
			);
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(155, doc.autoTable.previous.finalY + 10, $('#moreMsg39').text());

	        
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(150, doc.autoTable.previous.finalY + 15, $('#moreMsg40').text());
	    }
	    if ($('#tb_import_area6').css('display') === 'inline-block' && $("#tb_import_body6").length > 0) {
	        doc.addPage('l', 'mm');
	
	        doc.setFillColor(56, 60, 98);
	        doc.rect(0, 0, 500, 30, 'FD');
	
	        doc.setFontSize(20);
	        doc.setTextColor(255, 255, 255);
	        doc.text(20, 15, $('#tb_import_head6 tr:eq(0)>td:eq(0)>h1:eq(0)').text());
	
	
	        doc.setFontSize(15);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 25, $('#tb_import_head6 tr:eq(0)>td:eq(0)>div:eq(0)').text());
	
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo_w.png'
	        doc.addImage(img, 'png', 320, 10, 25, 10)
	
	        doc.autoTable(
				{ html: '#tb_import_body6',
				  styles: { font: "NotoSans-Regular", fontStyle: "normal", overflow: 'linebreak', cellWidth: 'wrap', lineColor: [240, 240, 240], lineWidth: 0.2 },
				  useCss: true,
				  startX: 10,
				  startY: 45,
				  includeHiddenHtml: false,
				  rowPageBreak: 'avoid',
				  headStyles: { halign: "center", valign: "middle" },
				  columnStyles: {
				    0: { cellWidth: 5 },
				    1: { cellWidth: 20 },
				    2: { cellWidth: 20 },
				    3: { cellWidth: 40 },
				    4: { cellWidth: 50 },
				    5: { cellWidth: 35 },
				    6: { cellWidth: 50 },
				    7: { cellWidth: 35 },
				    8: { cellWidth: 35 },
				    9: { cellWidth: 35 }
					}
				}
			);
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(155, doc.autoTable.previous.finalY + 10, $('#moreMsg41').text());

	        
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(150, doc.autoTable.previous.finalY + 15, $('#moreMsg42').text());
	    }
	    if ($('#tb_import_area7').css('display') === 'inline-block' && $("#tb_import_body7").length > 0) {
	        doc.addPage('l', 'mm');
	
	        doc.setFillColor(56, 60, 98);
	        doc.rect(0, 0, 500, 30, 'FD');
	
	        doc.setFontSize(20);
	        doc.setTextColor(255, 255, 255);
	        doc.text(20, 15, $('#tb_import_head7 tr:eq(0)>td:eq(0)>h1:eq(0)').text());
	
	
	        doc.setFontSize(15);
	        doc.setTextColor(255, 255, 102);
	        doc.text(20, 25, $('#tb_import_head7 tr:eq(0)>td:eq(0)>div:eq(0)').text());
	
	        var img = new Image()
	        img.src = '/pf/images/pdf_logo_w.png'
	        doc.addImage(img, 'png', 320, 10, 25, 10)
	
	        doc.autoTable(
				{ html: '#tb_import_body7',
				  styles: { font: "NotoSans-Regular", fontStyle: "normal", overflow: 'linebreak', cellWidth: 'wrap', lineColor: [240, 240, 240], lineWidth: 0.2 },
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
				    3: { cellWidth: 60 },
				    4: { cellWidth: 40 },
				    5: { cellWidth: 50 },
				    6: { cellWidth: 40 },
				    7: { cellWidth: 50 },
				    8: { cellWidth: 30 }
					}
				}
			);
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(155, doc.autoTable.previous.finalY + 10, $('#moreMsg43').text());

	        
	        doc.setFontSize(10);
	        doc.setTextColor(56, 60, 98);
	        doc.text(150, doc.autoTable.previous.finalY + 15, $('#moreMsg44').text());
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
    
    doc.save("report3.pdf");

}