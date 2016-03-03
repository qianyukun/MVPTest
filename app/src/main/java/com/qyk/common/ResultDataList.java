package com.qyk.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回数据类型<List>
 * @param <T>
 */
public class ResultDataList<T> extends ResultData<List<T>> {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

	public ResultDataList() {
        super();
	}

	public ResultDataList(Integer status, String message, List<T> data) {
	    super(status, message, data);
	}

    @Override
    public List<T> getData() {
        List<T> data = super.getData();
        if( data == null){
            data = new ArrayList<>();
        }
        return data;
    }
	
}
