//package bricks;

import java.awt.Image;
import java.awt.Rectangle;

class HardBrick extends Brick {
	/*
	 * @_hitCount - количество допустимых ударов шайбой
	 *            кирпич разрушается, как только атрибут
	 * 			  будет равен нулю
	 * @_woundImg - изображение поврежденого кирпича
	 * 			  заменяет исходное изображение при первом
	 * 			  ударе шайбы
	 */
	 
	private int _hitCount = 3;
	private Image _woundImg;
	private Image _woundImg1;

	public HardBrick(
		PlayField pf,
		BrickPile bp,
		Rectangle p,
		Image img,
		Image woundImg, Image woundImg1) {
			super(pf, bp, img, p);
			_woundImg = woundImg;
			_woundImg1 = woundImg1;



		}

		
	/* Oбработка соударения с шайбой. Как только
	 * значение _hitCount становится равным нулю
	 * и будет удален с игрового поля
	 */
	 
	public void hitBy(Puck p) {
		if (_hitCount - 1 >1){
			_img = _woundImg1;
			_hitCount--;
		}
		else if (_hitCount - 1 > 0) {
			_img = _woundImg;
			_hitCount--;
		} else {
			_isDead = true;
			if (_bp.unbrokenCount() == 0) {
				_pf.getMatch().win();
			}
		}
		
		p.getVelocity().reverseY();
	}
}
