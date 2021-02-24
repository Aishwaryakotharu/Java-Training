package com.service;

import java.io.FileOutputStream;

import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGen {
	Document doc = new Document();

	public PdfGen(String path) {
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createTablePdf(List<List<String>> data) throws DocumentException {
		doc.open();

		PdfPTable table = new PdfPTable(data.get(0).size());

		for (List<String> row : data)
			for (String cellValue : row)
				table.addCell(cellValue);
		doc.add(table);
		doc.close();

	}
}
