/*******************************************************************************
 * Mirakel is an Android App for managing your ToDo-Lists
 * 
 * Copyright (c) 2013-2014 Anatolij Zelenin, Georg Semmler.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package de.azapps.mirakel.model.list;

import android.content.ContentValues;
import de.azapps.mirakel.DefinitionsHelper.SYNC_STATE;
import de.azapps.mirakel.model.DatabaseHelper;
import de.azapps.mirakel.model.account.AccountMirakel;

class ListBase {
	// db-columns
	public final static String LFT = "lft";
	public final static String RGT = "rgt";
	public final static String COLOR = "color";
	public final static String SORT_BY = "sort_by";
	public final static String ACCOUNT_ID = "account_id";

	private int id;
	private String name;
	private int sortBy;
	private String created_at;
	private String updated_at;
	private SYNC_STATE syncState;
	private int lft, rgt;
	private int color;
	private int account;

	ListBase() {
	}

	ListBase(final int id, final String name, final short sort_by,
			final String created_at, final String updated_at,
			final SYNC_STATE sync_state, final int lft, final int rgt,
			final int color, final AccountMirakel a) {
		this.setId(id);
		this.setCreatedAt(created_at);
		this.setName(name);
		this.setUpdatedAt(updated_at);
		this.setSortBy(sort_by);
		this.setSyncState(sync_state);
		this.setLft(lft);
		this.setRgt(rgt);
		this.setColor(color);
		this.setAccount(a);
	}

	ListBase(final int id, final String name) {
		this.setId(id);
		this.setName(name);
	}

	protected ListBase(final int id, final String name, final short sort_by,
			final String created_at, final String updated_at,
			final SYNC_STATE sync_state, final int lft, final int rgt,
			final int color, final int account) {
		this.setId(id);
		this.setCreatedAt(created_at);
		this.setName(name);
		this.setUpdatedAt(updated_at);
		this.setSortBy(sort_by);
		this.setSyncState(sync_state);
		this.setLft(lft);
		this.setRgt(rgt);
		this.setColor(color);
		this.setAccount(account);
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getCreatedAt() {
		return this.created_at;
	}

	public void setCreatedAt(final String created_at) {
		this.created_at = created_at;
	}

	public String getUpdatedAt() {
		return this.updated_at;
	}

	public void setUpdatedAt(final String updated_at) {
		this.updated_at = updated_at;
	}

	public int getSortBy() {
		return this.sortBy;
	}

	public void setSortBy(final int sort_by) {
		this.sortBy = sort_by;
	}

	public int getLft() {
		return this.lft;
	}

	public void setLft(final int lft) {
		this.lft = lft;
	}

	public int getRgt() {
		return this.rgt;
	}

	public void setRgt(final int rgt) {
		this.rgt = rgt;
	}

	public int getColor() {
		return this.color;
	}

	public void setColor(final int color) {
		this.color = color;
	}

	public AccountMirakel getAccount() {
		return AccountMirakel.get(this.account);
	}

	public void setAccount(final AccountMirakel a) {
		setAccount(a.getId());
	}

	protected void setAccount(final int account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public ContentValues getContentValues() {
		final ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.ID, this.id);
		cv.put(DatabaseHelper.NAME, this.name);
		cv.put(DatabaseHelper.CREATED_AT, this.created_at);
		cv.put(DatabaseHelper.UPDATED_AT, this.updated_at);
		cv.put(SORT_BY, this.sortBy);
		cv.put(DatabaseHelper.SYNC_STATE_FIELD, this.syncState.toInt());
		cv.put(LFT, this.lft);
		cv.put(RGT, this.rgt);
		cv.put(COLOR, this.color);
		cv.put(ACCOUNT_ID, this.account);
		return cv;
	}

	public SYNC_STATE getSyncState() {
		return this.syncState;
	}

	public void setSyncState(final SYNC_STATE sync_state) {
		this.syncState = sync_state;
	}

}
