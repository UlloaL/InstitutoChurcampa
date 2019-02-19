package com.edu.iestpch.app.view.pdf;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.edu.iestpch.app.models.entity.Estudiante;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("/listarEst")
public class EstudiantePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		    	
            // Add Text to PDF file -> 
       	 Font  font   =   FontFactory . getFont ( FontFactory . COURIER ,   14) ; 
       	 Paragraph  para   =   new   Paragraph (   "Customer Table" ,   font ) ; 
       	 para . setAlignment ( Element . ALIGN_CENTER ) ; 
       	 document . add ( para ) ; 
       	 document . add ( Chunk . NEWLINE ) ; 
       	
       	 PdfPTable  table   =   new   PdfPTable ( 3 ) ; 
       	 // Add PDF Table Header -> 
            Stream . of ( "ID" ,   "First Name" ,   "Last Name" ) 
	             . forEach ( headerTitle   ->   { 
		               PdfPCell  header   =   new   PdfPCell ( ) ; 
		               Font  headFont   =   FontFactory . getFont ( FontFactory . HELVETICA_BOLD ) ; 		               
		               header . setHorizontalAlignment ( Element . ALIGN_CENTER ) ; 
		               header . setBorderWidth ( 2 ) ; 		               
		               table . addCell ( header ) ; 
	             } ) ; 
           List<Estudiante> estudiant = (List<Estudiante>) model.get("estudiante");
           
            for   ( Estudiante  estud   :   estudiant )   { 
           	 PdfPCell  idCell   =   new   PdfPCell (new Phrase(estud.getId())) ; 
           	 idCell . setPaddingLeft ( 4 ) ; 
           	 idCell . setVerticalAlignment ( Element . ALIGN_MIDDLE ) ; 
           	 idCell . setHorizontalAlignment ( Element . ALIGN_CENTER ) ; 
                table . addCell ( idCell ) ; 

                PdfPCell  firstNameCell   =   new   PdfPCell ( new   Phrase ( estud.getNombres()  ) ) ; 
                firstNameCell . setPaddingLeft ( 4 ) ; 
                firstNameCell . setVerticalAlignment ( Element . ALIGN_MIDDLE ) ; 
                firstNameCell . setHorizontalAlignment ( Element . ALIGN_LEFT ) ; 
                table . addCell ( firstNameCell ) ; 

                PdfPCell  lastNameCell   =   new   PdfPCell ( new   Phrase ( estud.getApellidos() ) ) ; 
                lastNameCell . setVerticalAlignment ( Element . ALIGN_MIDDLE ) ; 
                lastNameCell . setHorizontalAlignment ( Element . ALIGN_RIGHT ) ; 
                lastNameCell . setPaddingRight ( 4 ) ; 
                table . addCell ( lastNameCell ) ; 
            } 
            document . add ( table ) ; 
           
            document . close ( ) ; 
		} 
	 
}
		