import {scout} from '@eclipse-scout/core';
import {VatDo, VatForm} from '../../../main/js';

describe('VatForm', () => {
  let session: SandboxSession;

  beforeEach(() => {
    setFixtures(sandbox());
    session = sandboxSession({
      desktop: {
        // Bench is not visible by default for sandbox sessions.
        // It is required here because forms with display style view are opened
        benchVisible: true
      }
    });
  });

  describe('open with vat', () => {
    it('shows percentage and description', done => {
      let vatForm = scout.create(VatForm, {
        parent: session.desktop
      });

      let vat = scout.create(VatDo, {
        percentage: '8.1',
        description: 'Default vat of switzerland'
      });
      vatForm.setData(vat);
      vatForm.open()
        .then(() => {
          expect(vatForm.widget('PercentageField').rendered).toBe(true);
          expect(vatForm.widget('PercentageField').value.toString()).toBe(vat.percentage);
          expect(vatForm.widget('DescriptionField').rendered).toBe(true);
          expect(vatForm.widget('DescriptionField').value).toBe(vat.description);
          vatForm.close();
        })
        .catch(fail)
        .always(done);
    });
  });
});
