package com.pbapp.utilities;


import com.pbapp.utilities.rx.ThreadTransformer;

public interface UtilsComponent {

    StringUtils exposeStringUtils();

    ThreadTransformer exposeThreadTransformer();

}
