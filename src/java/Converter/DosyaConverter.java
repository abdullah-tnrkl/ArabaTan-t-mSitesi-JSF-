/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.DosyaDAO;
import Entity.Dosya;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "dosyaConverter")
public class DosyaConverter implements Converter{

    private DosyaDAO dosyaDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getDosyaDao().get(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Dosya dosya = (Dosya) value;
        return Integer.toString(dosya.getId());
    }

    public DosyaDAO getDosyaDao() {
        if(dosyaDao==null)
            dosyaDao =new DosyaDAO();
        return dosyaDao;
    }
    
    
}
