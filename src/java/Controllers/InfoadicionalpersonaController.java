package Controllers;

import EntityClasses.Infoadicionalpersona;
import Controllers.util.JsfUtil;
import Controllers.util.PaginationHelper;
import Facades.InfoadicionalpersonaFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("infoadicionalpersonaController")
@SessionScoped
public class InfoadicionalpersonaController implements Serializable {

    private Infoadicionalpersona current;
    private DataModel items = null;
    @EJB
    private Facades.InfoadicionalpersonaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public InfoadicionalpersonaController() {
    }

    public Infoadicionalpersona getSelected() {
        if (current == null) {
            current = new Infoadicionalpersona();
            current.setInfoadicionalpersonaPK(new EntityClasses.InfoadicionalpersonaPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private InfoadicionalpersonaFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Infoadicionalpersona) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Infoadicionalpersona();
        current.setInfoadicionalpersonaPK(new EntityClasses.InfoadicionalpersonaPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getInfoadicionalpersonaPK().setPersona(current.getPersona1().getIdentificacion());
            current.getInfoadicionalpersonaPK().setTipo(current.getInfoadicional().getCodigo());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InfoadicionalpersonaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Infoadicionalpersona) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getInfoadicionalpersonaPK().setPersona(current.getPersona1().getIdentificacion());
            current.getInfoadicionalpersonaPK().setTipo(current.getInfoadicional().getCodigo());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InfoadicionalpersonaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Infoadicionalpersona) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InfoadicionalpersonaDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Infoadicionalpersona getInfoadicionalpersona(EntityClasses.InfoadicionalpersonaPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Infoadicionalpersona.class)
    public static class InfoadicionalpersonaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InfoadicionalpersonaController controller = (InfoadicionalpersonaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "infoadicionalpersonaController");
            return controller.getInfoadicionalpersona(getKey(value));
        }

        EntityClasses.InfoadicionalpersonaPK getKey(String value) {
            EntityClasses.InfoadicionalpersonaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new EntityClasses.InfoadicionalpersonaPK();
            key.setPersona(Long.parseLong(values[0]));
            key.setTipo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(EntityClasses.InfoadicionalpersonaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getPersona());
            sb.append(SEPARATOR);
            sb.append(value.getTipo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Infoadicionalpersona) {
                Infoadicionalpersona o = (Infoadicionalpersona) object;
                return getStringKey(o.getInfoadicionalpersonaPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Infoadicionalpersona.class.getName());
            }
        }

    }

}
