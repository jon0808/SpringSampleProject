package com.sample.web.sample.service;

import java.util.List;
import com.sample.web.sample.vo.SampleVo;

public interface SampleService {
	
	/**
	 * Sample 리스트 조회
	 * @return
	 * @throws Exception
	 */
	public List<SampleVo> getDeptTable() throws Exception;
}