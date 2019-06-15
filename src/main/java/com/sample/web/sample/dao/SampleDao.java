package com.sample.web.sample.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.web.sample.vo.SampleVo;

@SuppressWarnings("deprecation")
@Repository("SampleDao")
public class SampleDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * Sample 리스트 조회
	 * @return
	 * @throws Exception
	 */
	public List<SampleVo> getDeptTable() throws Exception{
		return sqlSession.selectList("sample.getDeptTable");
	}
}