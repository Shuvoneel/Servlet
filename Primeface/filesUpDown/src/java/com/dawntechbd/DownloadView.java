package com.dawntechbd;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class DownloadView {

    private StreamedContent file;

    public DownloadView() {
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/two.jpg");
        file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_two.jpg");
    }

    public StreamedContent getFile() {
        return file;
    }
}
