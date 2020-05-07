/**
 * 
 */
package com.giang.daoimp;

import java.util.List;

import com.giang.entity.SanPham;

/**
 * @author slytherin
 *
 */
public interface SanPhamDAOimp {
	public List<SanPham> LayDanhSachSanPham(int sanphamdau);
	public List<SanPham> LayDanhSachSanPhamFull();
	public SanPham LaySanPhamTheoMaSanPham(int masanpham);
}
