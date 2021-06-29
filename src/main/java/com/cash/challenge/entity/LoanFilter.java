package com.cash.challenge.entity;

import com.cash.challenge.dao.AbstractFilter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class LoanFilter extends AbstractFilter<Loan> {

    private Long userId;

    @Override
    protected void populatePredicates(List<Predicate> predicates, Root<Loan> root, CriteriaBuilder critBuilder) {
        User user = new User();
        user.setId(userId);
        Predicate predicateForUser = critBuilder.equal(root.get("user"),user);
        predicates.add(predicateForUser);

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString(){
        return "LoanFilter:UserId:"+(userId==null?"null":userId.toString());
    }

}
