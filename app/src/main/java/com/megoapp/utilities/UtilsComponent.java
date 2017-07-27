package com.megoapp.utilities;


import com.megoapp.utilities.rx.ThreadTransformer;

public interface UtilsComponent {

    StringUtils exposeStringUtils();

    ThreadTransformer exposeThreadTransformer();

}
