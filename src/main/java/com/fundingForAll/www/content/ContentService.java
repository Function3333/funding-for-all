package com.fundingForAll.www.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ContentService {

    private ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    /*save할때 각각의 form을 생성해서 할건지 아니면 contentForm 하나로 저장 하는 방법 없는지 아니면
    * 그냥 form 없이 사용 할 건지*/

    @Transactional
    public String save(Content content) {
        contentRepository.save(content);

        return content.getId();
    }

    @Transactional
    public void deleteById(String contentId) {
        contentRepository.deleteById(contentId);
    }

    public String findImageByUserId(String userId) {
        Optional<String> findImg = contentRepository.findImageByUserId(userId);

        return (findImg.isPresent()) ? findImg.get() : null;
    }

    public List<String> findImageByFundId(int fundId) {
        return contentRepository.findImageByFundId(fundId);
    }

    public List<String> findVideoByFundId(int fundId) {
        return contentRepository.findVideoByFundId(fundId);
    }

    public String findMusicByFundId(int fundId) {
        return contentRepository.findMusicByFundId(fundId);
    }
}
