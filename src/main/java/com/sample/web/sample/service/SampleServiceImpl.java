package com.sample.web.sample.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.web.sample.dao.SampleDao;
import com.sample.web.sample.vo.SampleVo;

@Service("SampleService")
public class SampleServiceImpl implements SampleService {

     @Resource(name="SampleDao")
     private SampleDao sampleDao;

     @Override
     public List<SampleVo> getDeptTable() throws Exception {
         return sampleDao.getDeptTable();
     }
}
	