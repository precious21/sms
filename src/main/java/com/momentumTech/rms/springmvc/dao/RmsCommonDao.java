package com.momentumTech.rms.springmvc.dao;

import java.io.Serializable;

public interface RmsCommonDao extends Serializable {

  boolean updateByQuery(String query);  

}
