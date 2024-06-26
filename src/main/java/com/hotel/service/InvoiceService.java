package com.hotel.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;



@Service
public class InvoiceService {
	
	@Autowired
	BookingService bookingservice;
	
	@Autowired
	RoomService roomservice;
	
	public String generateInvoice(Long BookingId)
	{
		
		
		return "";
	}
	
	public String addchunk(Long BookingId)
	{
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(BookingId+".pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 24, BaseColor.BLACK);
		Chunk chunk = new Chunk("Hotel Invoice", font);

		try {
			document.add(chunk);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
		
		return "";
	}
	

	public String addImage(Long BookingId) throws URISyntaxException, DocumentException, MalformedURLException, IOException
	{
		Path path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("iTextImageExample.pdf"));
		document.open();
		Image img = Image.getInstance(path.toAbsolutePath().toString());
		document.add(img);

		document.close();
		
		return "";
	}

	public String generateInvoice2(Long BookingId)
	{
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("iTextTable.pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		document.open();

		PdfPTable table = new PdfPTable(3);
		addTableHeader(table);
		addRows(table);
		
			//addCustomRows(table);
	

		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
		
		
		return "";
	}
	private void addTableHeader(PdfPTable table) {
	    Stream.of("column header 1", "column header 2", "column header 3")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	private void addRows(PdfPTable table) {
	    table.addCell("row 1, col 1");
	    table.addCell("row 1, col 2");
	    table.addCell("row 1, col 3");
	}
	private void addCustomRows(PdfPTable table) 
			  throws URISyntaxException, BadElementException, IOException {
			    Path path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
			    Image img = Image.getInstance(path.toAbsolutePath().toString());
			    img.scalePercent(10);

			    PdfPCell imageCell = new PdfPCell(img);
			    table.addCell(imageCell);

			    PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
			    horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    table.addCell(horizontalAlignCell);

			    PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
			    verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
			    table.addCell(verticalAlignCell);
			}

	public String generateInvoice3(Long BookingId) throws IOException, DocumentException
	{
		
		PdfReader pdfReader = new PdfReader("iTextTable.pdf");
		PdfStamper pdfStamper 
		  = new PdfStamper(pdfReader, new FileOutputStream("encryptedPdf.pdf"));

		pdfStamper.setEncryption(
		  "userpass".getBytes(),
		  "ownerpass".getBytes(),
		  PdfWriter.ALLOW_PRINTING | PdfWriter.ALLOW_COPY,
		  PdfWriter.ENCRYPTION_AES_256
		);

		pdfStamper.close();
		return "";
	}

}
