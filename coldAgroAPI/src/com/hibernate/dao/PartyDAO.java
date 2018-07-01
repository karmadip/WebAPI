package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hibernate.HibernateUtil;
import com.hibernate.model.Party;

public class PartyDAO {

	public Party getPartyByName(String partyName) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			@SuppressWarnings("unchecked")
			List<Party> partyList = session.createCriteria(Party.class).add(Restrictions.eq("partyName", partyName))
					.list();
			if (partyList.size() > 0) {
				return partyList.get(0);
			} else {
				return null;
			}

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Party save(Party party) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(party);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return party;
	}

}
